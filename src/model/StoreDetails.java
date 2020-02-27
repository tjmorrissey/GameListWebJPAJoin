package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store_details")
public class StoreDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STORE_ID")
	private int storeId;
	@Column(name="STORE_NAME")
	private String storeName;
	@Column(name="ADDRESS")
	private String address;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	(
			name="Games_in_STORE", 
			joinColumns= { @JoinColumn(name="STORE_ID", referencedColumnName="STORE_ID") },
			inverseJoinColumns= { @JoinColumn(name="GAME_ID", referencedColumnName="ID", unique=true) }
	)
	private List<ListItem> listOfGames;
	
	public StoreDetails() {
		super();
	}
	
	public StoreDetails(String storeName, String address) {
		super();
		this.storeName = storeName;
		this.address = address;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StoreDetails [storeId=" + storeId + ", storeName=" + storeName + ", address=" + address + "]";
	}
	
	
	
}
