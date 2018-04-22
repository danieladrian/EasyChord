package net.danieladrian.chordrepository.realm;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmConfig {
    public void MigrationConfig(){
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(1) // Must be bumped when the schema changes
                .migration(new Migration()) // Migration to run instead of throwing an exception
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
