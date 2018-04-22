package net.danieladrian.chordrepository.realm.schema;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CategorySchema extends RealmObject {

    @PrimaryKey
    String id;
    @Required
    String category;
    RealmList<SongSchema> songList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public RealmList<SongSchema> getSongList() {
        return songList;
    }

    public void setSongList(RealmList<SongSchema> songList) {
        this.songList = songList;
    }
}
