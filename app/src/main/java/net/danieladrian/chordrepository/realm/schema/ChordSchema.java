package net.danieladrian.chordrepository.realm.schema;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class ChordSchema extends RealmObject {

    @LinkingObjects("chordList")
    private final RealmResults<SongSchema> songSchemas = null;
    @PrimaryKey
    String id;
    int pos;
    int align;
    int chordRoot;
    int chordVariant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public int getChordRoot() {
        return chordRoot;
    }

    public void setChordRoot(int chordRoot) {
        this.chordRoot = chordRoot;
    }

    public int getChordVariant() {
        return chordVariant;
    }

    public void setChordVariant(int chordVariant) {
        this.chordVariant = chordVariant;
    }
}
