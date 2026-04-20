package com.pega.crm.customerservice.tiles;

import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Forecast;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.crm.salesautomation.workobjects.PartnersList;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;										   

public interface LeftNav {
	
	OrganizationsList getOrganizationList();
	OperatorList getOperatorsList();
	ContactList getContactList();
	AccountList getAccountList();
	OpportunityList getOpportunityList();
	PartnersList getPartnersList();
	HouseholdList getHouseholdList();
	LeadsList getLeadsList();
	String getLatestRecent();
	TerritoriesList getTerritoriesList();
	Forecast getForecast();
	ClosePlans getClosePlans();
}
