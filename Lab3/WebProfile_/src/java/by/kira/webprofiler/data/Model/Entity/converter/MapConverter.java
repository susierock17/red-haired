/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data.Model.Entity.converter;

import by.kira.webprofiler.data.Model.DAO.CastingDAO;
import by.kira.webprofiler.data.Model.DAO.GenreDAO;
import by.kira.webprofiler.data.Model.DAO.SoundmanDAO;
import by.kira.webprofiler.data.Model.Entity.*;
import java.util.Map;

/**
 *
 * @author Kira
 */
public class MapConverter {

    public static Genre toGenre(Map<String, String[]> map)
    {
        Genre result = new Genre();
       //result.setGenreName(map.get("genre")[0]);
        int id = Integer.parseInt(map.get("genreSelection")[0]);
        return GenreDAO.findEntityById(id);
    }

    public static Soundman toSoundman(Map<String, String[]> map)
    {
        Soundman result = new Soundman();
        int id = Integer.parseInt(map.get("soundmanSelection")[0]);
        return SoundmanDAO.findEntityById(id);
    }

    public static Casting toCasting(Map<String, String[]> map)
    {
        Casting result = new Casting();
//        result.setActorList(map.get("cast")[0]);
        int id = Integer.parseInt(map.get("castingSelection")[0]);
        return CastingDAO.findEntityById(id);
    }

    public static Project toProject(Map<String, String[]> map)
    {
        Project result = new Project();
        result.setDescription(map.get("description")[0]);
        result.setProjectName(map.get("name")[0]);
        result.setPublishYear(map.get("year")[0]);
        result.setCastingId(toCasting(map));
        result.setGenreId(toGenre(map));
        result.setSoundmanId(toSoundman(map));
        return result;
    }
}
