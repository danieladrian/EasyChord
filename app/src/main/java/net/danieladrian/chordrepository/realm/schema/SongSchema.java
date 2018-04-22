package net.danieladrian.chordrepository.realm.schema;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class SongSchema extends RealmObject {

    @LinkingObjects("songList")
    private final RealmResults<CategorySchema> categorySchemas = null;
    @PrimaryKey
    String id;
    String lyric;
    String author;
    String userIdentifier;
    RealmList<ChordSchema> chordList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public RealmList<ChordSchema> getChordList() {
        return chordList;
    }

    public void setChordList(RealmList<ChordSchema> chordList) {
        this.chordList = chordList;
    }
}
