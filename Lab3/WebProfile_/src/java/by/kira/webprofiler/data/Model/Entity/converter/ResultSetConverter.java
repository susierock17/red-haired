/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data.Model.Entity.converter;

import by.kira.webprofiler.data.Model.DAO.CastingDAO;
import by.kira.webprofiler.data.Model.DAO.GenreDAO;
import by.kira.webprofiler.data.Model.DAO.SoundmanDAO;
import by.kira.webprofiler.data.Model.Entity.Casting;
import by.kira.webprofiler.data.Model.Entity.Genre;
import by.kira.webprofiler.data.Model.Entity.Project;
import by.kira.webprofiler.data.Model.Entity.Soundman;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class ResultSetConverter {
    public static Genre toGenre(ResultSet rs)
    {
        Genre result = null;
        try {
            result = new Genre();
            result.setIdGenre(rs.getInt(1));
            result.setGenreName(rs.getString(2));
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static Soundman toSoundman(ResultSet rs)
    {
        try {
            Soundman result = new Soundman();
            result.setIdSoundman(rs.getInt(1));
            result.setSoundmanName(rs.getString(2));
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Casting toCasting(ResultSet rs)
    {
        try {
            Casting result = new Casting();
            result.setIdCasting(rs.getInt(1));
            result.setActorList(rs.getString(2));
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Project toProject(ResultSet rs)
    {
        try {
            Project result = new Project();
            result.setIdProject(rs.getInt(1));
            result.setProjectName(rs.getString(2));
            result.setDescription(rs.getString(3));
            result.setPublishYear(rs.getString(4));
            result.setGenreId(GenreDAO.findEntityById(rs.getInt(5)));
            result.setSoundmanId(SoundmanDAO.findEntityById(rs.getInt(6)));
            result.setCastingId(CastingDAO.findEntityById(rs.getInt(7)));
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
