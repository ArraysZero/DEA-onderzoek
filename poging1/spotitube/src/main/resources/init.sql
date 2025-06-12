CREATE TABLE User (
  username TEXT,
  password TEXT,
  token TEXT
);

CREATE TABLE Track (
  id INTEGER,
  title TEXT,
  performer TEXT,
  duration INTEGER,
  album TEXT,
  playcount INTEGER,
  publicationDate TEXT,
  description TEXT,
  offlineAvailable INTEGER
);

CREATE TABLE Playlist (
  id INTEGER,
  name TEXT,
  owner TEXT
);

CREATE TABLE TrackOnPlaylist (
  trackID INTEGER,
  playlistID INTEGER
);
