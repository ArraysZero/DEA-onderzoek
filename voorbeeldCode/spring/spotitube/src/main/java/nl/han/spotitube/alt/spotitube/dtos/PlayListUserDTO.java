package nl.han.spotitube.alt.spotitube.dtos;

public class PlayListUserDTO {

	private int id;
	private String name;
	private boolean owner;
	private TrackDTO[] tracks;
	public PlayListUserDTO(int id, String name, boolean owner, TrackDTO[] tracks) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.tracks = tracks;
	}
	public PlayListUserDTO(int id, String name, boolean owner) {
		this.id = id;
		this.name = name;
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getOwner() {
		return owner;
	}
	public void setOwner(boolean owner) {
		this.owner = owner;
	}
	public TrackDTO[] getTracks() {
		return tracks;
	}
	public void setTracks(TrackDTO[] tracks) {
		this.tracks = tracks;
	}

	
}