package rest.model;

import rest.model.entity.EClient;
import rest.model.entity.EUser;
import rest.model.entity.EAd;
import java.util.List;
import java.sql.*;

public interface IModel {
	void get_ad(EAd ad, String user_data);
	String get_next_ad_id();
	void add_ad(EAd ad) throws Exception;
}
