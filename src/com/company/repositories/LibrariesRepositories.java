package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Library;
import com.company.repositories.interfaces.ILibrariesRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LibrariesRepositories implements ILibrariesRepositories{
    private final IDB db;

    public LibrariesRepositories(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addLibrary(Library library) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO libraries(library_id, library_address, start_time, end_time) VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, library.getLibraryId());
            st.setString(2, library.getLibraryAddress());
            st.setTime(3, library.getStartTime());
            st.setTime(4, library.getEndTime());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public Library getLibraryById(int libraryId) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT* FROM libraries WHERE library_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, libraryId);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Library library = new Library(rs.getInt("library_id"),
                        rs.getString("library_address"),
                        rs.getTime("start_time"),
                        rs.getTime("end_time"));

                return library;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Library> getLibraryByAddress(String libraryAddress) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT library_id, library_address, start_time, end_time FROM libraries WHERE library_address =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, libraryAddress);

            ResultSet rs = st.executeQuery();
            List<Library> libraries = new LinkedList<>();
            if (rs.next()) {
                Library library = new Library(rs.getInt("library_id"),
                        rs.getString("library_address"),
                        rs.getTime("start_time"),
                        rs.getTime("end_time"));

                libraries.add(library);
            }
            return libraries;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public int updateLibraryAddress(Library library) {
        Connection con = null;
        int rowsAffected = 0;

        try {
            con = db.getConnection();
            String sql = "UPDATE libraries SET library_address =? WHERE library_id =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, library.getLibraryAddress());
            st.setInt(2, library.getLibraryId());

            rowsAffected = st.executeUpdate();
            return rowsAffected;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return rowsAffected;
    }

    @Override
    public int deleteLibrary(Library library) {
        Connection con = null;
        int rowsAffected = 0;

        try {
            con = db.getConnection();
            String sql = "DELETE FROM libraries WHERE library_id =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, library.getLibraryId());

            rowsAffected = st.executeUpdate();
            return rowsAffected;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return rowsAffected;
    }

    @Override
    public List<Library> getAllLibraries() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT* FROM libraries";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Library> libraries = new LinkedList<>();
            while (rs.next()) {
                Library library = new Library(rs.getInt("library_id"),
                        rs.getString("library_address"),
                        rs.getTime("start_time"),
                        rs.getTime("end_time"));

                libraries.add(library);
            }

            return libraries;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }
}
