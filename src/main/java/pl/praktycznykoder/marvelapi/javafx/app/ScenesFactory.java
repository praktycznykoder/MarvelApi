/*
 * Copyright (C) 2018 praktycznykoder.pl
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package pl.praktycznykoder.marvelapi.javafx.app;

/**
 *
 * @author praktycznykoder.pl
 */
public class ScenesFactory {

    /**
     *
     */
    private final static SceneData[] SCENES ={
        new SceneData("characters", "/fxml/Character.fxml",
                "/fxml/CharacterDetails.fxml", "Character"),
        new SceneData("comics", "/fxml/Comics.fxml",
                "/fxml/ComicsDetails.fxml", "Comics"),
        new SceneData("creators", "/fxml/Creator.fxml",
                "/fxml/CreatorDetails.fxml", "Creator"),
        new SceneData("events", "/fxml/Event.fxml",
                "/fxml/EventDetails.fxml", "Event"),
        new SceneData("series", "/fxml/Series.fxml",
                "/fxml/SeriesDetails.fxml", "Series"),
        new SceneData("stories", "/fxml/Story.fxml",
                "/fxml/StoryDetails.fxml", "Story")
    };
    
    public static SceneData getSceneData(String sceneName){
        for (SceneData sceneData : SCENES) {
            if(sceneData.getName().equals(sceneName)){
                return sceneData;
            }
        }
        return null;
    }
    
    
}
