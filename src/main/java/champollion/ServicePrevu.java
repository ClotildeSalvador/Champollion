package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
	private int volumeCM ;
	private int volumeTD ;
	private int volumeTP ;
	private UE ue ;
	
	public ServicePrevu(int CM, int TD, int TP, UE ue) {
		this.volumeCM=CM ;
		this.volumeTD=TD ;
		this.volumeTP=TP ;
		this.ue = ue ;
	}
	
	public UE getUe() {
		return ue;
	}

	public void setUe(UE ue) {
		this.ue = ue;
	}

	public int getVolumeCM() {
		return volumeCM;
	}

	public void setVolumeCM(int volumeCM) {
		this.volumeCM = volumeCM;
	}

	public int getVolumeTD() {
		return volumeTD;
	}

	public void setVolumeTD(int volumeTD) {
		this.volumeTD = volumeTD;
	}

	public int getVolumeTP() {
		return volumeTP;
	}

	public void setVolumeTP(int volumeTP) {
		this.volumeTP = volumeTP;
	}
	
}
