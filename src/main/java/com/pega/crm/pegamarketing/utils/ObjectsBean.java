package com.pega.crm.pegamarketing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.ExpressPortal;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.dialog.ImageCatalogDialog;
import com.pega.crm.pegamarketing.pages.CampaignsFrame;
import com.pega.crm.pegamarketing.pages.Channels;
import com.pega.crm.pegamarketing.pages.Channels.PaidMediaSetting;
import com.pega.crm.pegamarketing.pages.ContextDictionary;
import com.pega.crm.pegamarketing.pages.DataFlows;
import com.pega.crm.pegamarketing.pages.Eligibilities;
import com.pega.crm.pegamarketing.pages.ImageLibrary;
import com.pega.crm.pegamarketing.pages.Microsites;
import com.pega.crm.pegamarketing.pages.Offers;
import com.pega.crm.pegamarketing.pages.PaidMediaAudiences;
import com.pega.crm.pegamarketing.pages.ProspectLists;
import com.pega.crm.pegamarketing.pages.RealTimeArtifacts;
import com.pega.crm.pegamarketing.pages.RecentReports;
import com.pega.crm.pegamarketing.pages.Segments;
import com.pega.crm.pegamarketing.pages.Segments.ImageCatalog;
import com.pega.crm.pegamarketing.pages.ServiceRestRecords;
import com.pega.crm.pegamarketing.pages.Strategies;
import com.pega.crm.pegamarketing.pages.Subscription;
import com.pega.crm.pegamarketing.pages.Summaries;
import com.pega.crm.pegamarketing.pages.Treatments;
import com.pega.crm.pegamarketing.pages.UnsubscribedCustomers;
import com.pega.crm.pegamarketing.pages.UnsubscribedCustomers.SubscriptionReportDrillDown;
import com.pega.crm.pegamarketing.rules.Campaign;
import com.pega.crm.pegamarketing.rules.Campaign.CampaignConfigureDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureAudienceDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureDetailsDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureEngagementCriteriaDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureEngagementDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureMarketingStrategyDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureTimeframeDialog;
import com.pega.crm.pegamarketing.rules.Designer;
import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.crm.pegamarketing.rules.MarketingStrategy;
import com.pega.crm.pegamarketing.rules.MarketingStrategy.ConfigureObjectiveDialog;
import com.pega.crm.pegamarketing.rules.MarketingStrategy.ConfigurePriorityDialog;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.rules.PropositionFilter;
import com.pega.crm.pegamarketing.rules.ProspectImport;
import com.pega.crm.pegamarketing.rules.SMSTreatment;
import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.crm.pegamarketing.rules.WhenRule;
import com.pega.crm.pegamarketing.rules.WhenRule.ConditionDialog;

public class ObjectsBean {

	private static Segments segments;
	static Eligibilities eligibilities;
	static String Strategy1, Strategy2, Campaign1, Campaign2;
	private static ConfigurePriorityDialog configurePriorityDialog;
	private static ImageCatalog ic;
	private static HashMap<String, String> timeStamps = new HashMap<>();
	private static Segment segment;
	private static Map<String, String> objectNames = new LinkedHashMap<String, String>();
	private static DesignerStudio designerStudio;
	private static PMPortal pmPortal;
	private static Designer designer;
	private static CampaignsFrame campaigns;
	private static ContextDictionary contextDictionaryFrame;
	private static ExpressPortal expressPortal;
	private static com.pega.crm.pegamarketing.rules.Designer.ConfigureBussinessIssuesDialog configBussIssue;
	private static Campaign campaign;
	private static ConfigureMarketingStrategyDialog configureMarketingStrategyDialog;
	private static RealTimeArtifacts realTimeArtifacts;
	private static Treatments treatments;
	private static ConfigureAudienceDialog configureAudienceDialog;
	private static ConfigureEngagementDialog configureEngagementDialog;
	private static Strategies strategy;
	private static MarketingStrategy marketingStrat;
	private static ConfigureObjectiveDialog confgObjectiveDialog;
	private static EmailTreatment emailTreatment;
	private static Offers offers;
	private static Offer offer;
	private static WhenRule when;
	private static ConditionDialog conditionDialog;
	private static PropositionFilter propositionfilter;
	private static SMSTreatment smsTreatment;
	private static ProspectLists prospectLists;
	private static ProspectImport prospectImport;
	private static Channels channels;
	private static Microsites microsites;
	private static DataFlows dataFlows;
	private static Summaries summaries;
	private static RecentReports recentreports;
	private static UnsubscribedCustomers unsubscribedCustomers;
	private static ServiceRestRecords serviceRestRecords;
	private static Subscription subsription;
	private static SubscriptionReportDrillDown subscriptionDrillDrown;
	private static PaidMediaSetting pegapaidmedia;
	private static PaidMediaAudiences paidMediaAudiences;
	private static ImageLibrary imageLibrary;
	private static ImageCatalogDialog imgCatalog;

	public static ConfigureEngagementCriteriaDialog configureEngagementCriteriaDialog;
	public static CampaignConfigureDialog cardSelectorDialog;
	public static ConfigureTimeframeDialog configureTimeframeDialog;
	public static ConfigureDetailsDialog configureDetailsDialog;

	public static void setSegments(Segments segments) {
		ObjectsBean.segments = segments;
	}

	public static Segments getSegments() {
		return ObjectsBean.segments;
	}

	public static void setStrategyName(String Strategy1) {
		ObjectsBean.Strategy1 = Strategy1;
	}

	public static String getStrategyName() {
		return ObjectsBean.Strategy1;
	}

	public static void setStrategyName1(String Strategy2) {
		ObjectsBean.Strategy2 = Strategy2;
	}

	public static String getStrategyName1() {
		return ObjectsBean.Strategy2;
	}

	public static void setImageCatalog(ImageCatalog ic) {
		ObjectsBean.ic = ic;
	}

	public static ImageCatalog getImageCatalog() {
		return ObjectsBean.ic;
	}

	public static String putTimeStampedValue(String name) {
		String existingValue = timeStamps.get(name);
		if (existingValue == null) {
			String value = appendTimeStamp(name);
			ObjectsBean.timeStamps.put(name, value);
			return value;
		} else {
			return existingValue;
		}
	}

	public static String getTimeStampedValue(String name) {
		String value = timeStamps.get(name);
		if (value != null) {
			return value;
		} else {
			return name;
		}
	}

	private static String appendTimeStamp(String string) {
		String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
		return string + timeStamp;
	}

	public static void setSegment(Segment segment) {
		ObjectsBean.segment = segment;
	}

	public static Segment getSegment() {
		return ObjectsBean.segment;
	}

	public static void setDesignerStudio(DesignerStudio designerStudio) {
		ObjectsBean.designerStudio = designerStudio;
	}

	public static DesignerStudio getDesignerStudio() {
		return designerStudio;
	}

	public static void setPMPortal(PMPortal pmPortal) {
		ObjectsBean.pmPortal = pmPortal;
	}

	public static PMPortal getPMPortal() {
		return pmPortal;
	}

	public static void setDesigner(Designer designer) {
		ObjectsBean.designer = designer;
	}

	public static Designer getDesigner() {
		return designer;
	}

	public static void setContextDictionaryFrame(ContextDictionary contextDictionaryFrame) {
		ObjectsBean.contextDictionaryFrame = contextDictionaryFrame;
	}

	public static ContextDictionary getContextDictionaryFrame() {
		return ObjectsBean.contextDictionaryFrame;
	}

	public static ExpressPortal getExpressPortal() {
		return ObjectsBean.expressPortal;
	}

	public static void setExpressPortal(ExpressPortal expressPortal) {
		ObjectsBean.expressPortal = expressPortal;
	}

	public static void setConfigBussinessIssueDialog(
			com.pega.crm.pegamarketing.rules.Designer.ConfigureBussinessIssuesDialog configBussIssue) {
		ObjectsBean.configBussIssue = configBussIssue;
	}

	public static com.pega.crm.pegamarketing.rules.Designer.ConfigureBussinessIssuesDialog getConfigBussinessIssuesDialog() {
		return ObjectsBean.configBussIssue;
	}

	public static Map<String, String> getObjectNames() {
		return objectNames;
	}

	public static void setCampaigns(CampaignsFrame campaigns) {
		ObjectsBean.campaigns = campaigns;
	}

	public static CampaignsFrame getCampaigns() {
		return campaigns;
	}

	public static void setCampaign(Campaign campaign) {
		ObjectsBean.campaign = campaign;
	}

	public static Campaign getCampaign() {
		return campaign;
	}

	public static void setConfigureMarketingStrategyDiaolg(
			ConfigureMarketingStrategyDialog configureMarketingStrategyDialog) {
		ObjectsBean.configureMarketingStrategyDialog = configureMarketingStrategyDialog;
	}

	public static ConfigureMarketingStrategyDialog getConfigureMarketingStrategyDialog() {
		return configureMarketingStrategyDialog;
	}

	public static void setRealTimeArtifacts(RealTimeArtifacts realTimeArtifacts) {
		ObjectsBean.realTimeArtifacts = realTimeArtifacts;

	}

	public static RealTimeArtifacts getRealTimeArtifacts() {
		return ObjectsBean.realTimeArtifacts;

	}

	public static void setTreatments(Treatments treatments) {
		ObjectsBean.treatments = treatments;
	}

	public static void setOffers(Offers offers) {
		ObjectsBean.offers = offers;
	}

	public static Treatments getTreatments() {
		return ObjectsBean.treatments;
	}

	public static Offers getOffers() {
		return ObjectsBean.offers;
	}

	public static void setOffer(Offer offer) {
		ObjectsBean.offer = offer;
	}

	public static Offer getOffer() {
		return ObjectsBean.offer;
	}

	public static void setConfigureAudienceDiaolg(ConfigureAudienceDialog configureAudienceDialog) {
		ObjectsBean.configureAudienceDialog = configureAudienceDialog;
	}

	public static ConfigureAudienceDialog getConfigureAudienceDialog() {
		return configureAudienceDialog;
	}

	public static void setConfigureEngagementDiaolg(ConfigureEngagementDialog configureEngagementDialog) {
		ObjectsBean.configureEngagementDialog = configureEngagementDialog;
	}

	public static ConfigureEngagementDialog getConfigureEngagementDialog() {
		return configureEngagementDialog;
	}

	public static void setConfigureEngagementCriteriaDialog(
			ConfigureEngagementCriteriaDialog configureEngagementCriteriaDialog) {
		ObjectsBean.configureEngagementCriteriaDialog = configureEngagementCriteriaDialog;
	}

	public static ConfigureEngagementCriteriaDialog getConfigureEngagementCriteriaDialog() {
		return configureEngagementCriteriaDialog;
	}

	public static void setCardSelectorDialog(CampaignConfigureDialog cardSelectorDialog) {
		ObjectsBean.cardSelectorDialog = cardSelectorDialog;
	}

	public static CampaignConfigureDialog getCardSelectorDialog() {
		return cardSelectorDialog;
	}

	public static void setConfigureTimeframeDialog(ConfigureTimeframeDialog configureTimeframeDialog) {
		ObjectsBean.configureTimeframeDialog = configureTimeframeDialog;
	}

	public static ConfigureTimeframeDialog getConfigureTimeframeDialog() {
		return configureTimeframeDialog;
	}

	public static void setConfigureDetailsDialog(ConfigureDetailsDialog configureDetailsDialog) {
		ObjectsBean.configureDetailsDialog = configureDetailsDialog;
	}

	public static ConfigureDetailsDialog getConfigureDetailsDialog() {
		return configureDetailsDialog;
	}

	public static void setStrategies(Strategies strategies) {
		ObjectsBean.strategy = strategies;
	}

	public static Strategies getStrategies() {
		return strategy;
	}

	public static void setStrategy(MarketingStrategy strategy) {
		ObjectsBean.marketingStrat = strategy;
	}

	public static MarketingStrategy getStrategy() {
		return marketingStrat;
	}

	public static void setConfigureObjectiveDialog(ConfigureObjectiveDialog confgObjectiveDialog) {
		ObjectsBean.confgObjectiveDialog = confgObjectiveDialog;
	}

	public static ConfigureObjectiveDialog getConfigureObjectiveDialog() {
		return confgObjectiveDialog;
	}

	public static void setEmailTreatment(EmailTreatment emailTreatment) {
		ObjectsBean.emailTreatment = emailTreatment;
	}

	public static EmailTreatment getEmailTreatment() {
		return ObjectsBean.emailTreatment;
	}

	public static void setConfigurePriorityDialog(ConfigurePriorityDialog configurePriorityDialog) {
		ObjectsBean.configurePriorityDialog = configurePriorityDialog;
	}

	public static ConfigurePriorityDialog getConfigurePriorityDialog() {
		return configurePriorityDialog;
	}

	public static void setEligibilities(Eligibilities eligibilities) {
		ObjectsBean.eligibilities = eligibilities;
	}

	public static Eligibilities getEligibilities() {
		return eligibilities;
	}

	public static void setWhen(WhenRule when) {
		ObjectsBean.when = when;
	}

	public static WhenRule getWhen() {
		return when;
	}

	public static void setConditionDialog(ConditionDialog conditionDialog) {
		ObjectsBean.conditionDialog = conditionDialog;
	}

	public static ConditionDialog getConditionDialog() {
		return conditionDialog;
	}

	public static void setPropositionFilter(PropositionFilter propositionFilter) {
		ObjectsBean.propositionfilter = propositionFilter;
	}

	public static PropositionFilter getPropositionFilter() {
		return propositionfilter;
	}

	public static SMSTreatment getSMSTreatment() {
		return smsTreatment;
	}

	public static void setSMSTreatment(SMSTreatment smsTreatment) {
		ObjectsBean.smsTreatment = smsTreatment;
	}

	public static void setProspectLists(ProspectLists prospectLists) {
		ObjectsBean.prospectLists = prospectLists;
	}

	public static ProspectLists getProspectLists() {
		return prospectLists;
	}

	public static void setProspectImport(ProspectImport prospectImport) {
		ObjectsBean.prospectImport = prospectImport;
	}

	public static ProspectImport getProspectImport() {
		return prospectImport;
	}

	public static void setChannels(Channels channels) {
		ObjectsBean.channels = channels;
	}

	public static Channels getChannels() {
		return channels;
	}

	public static void setMicrosites(Microsites microsites) {
		ObjectsBean.microsites = microsites;
	}

	public static Microsites getMicroSites() {
		return microsites;
	}

	public static void setDataFlows(DataFlows dataFlows) {
		ObjectsBean.dataFlows = dataFlows;
	}

	public static DataFlows getDataFlows() {
		return dataFlows;
	}

	public static void setSummaries(Summaries summaries) {
		ObjectsBean.summaries = summaries;
	}

	public static Summaries getSummaries() {
		return summaries;
	}

	public static void setRecentReports(RecentReports recentReports) {
		ObjectsBean.recentreports = recentReports;
	}

	public static RecentReports getRecentReports() {
		return recentreports;
	}

	public static void setUnsubscribedCustomers(UnsubscribedCustomers unsubscribedCustomers) {
		ObjectsBean.unsubscribedCustomers = unsubscribedCustomers;
	}

	public static UnsubscribedCustomers getUnsubscribedCustomers() {
		return unsubscribedCustomers;
	}

	public static ServiceRestRecords getServiceRestRecords() {
		return serviceRestRecords;
	}

	public static void setServiceRestRecords(ServiceRestRecords serviceRestRecords) {
		ObjectsBean.serviceRestRecords = serviceRestRecords;

	}

	public static Subscription getSubscription() {
		return subsription;
	}

	public static void setSubscription(Subscription subscription) {
		ObjectsBean.subsription = subscription;
	}

	public static SubscriptionReportDrillDown getSubscriptionReportDrillDown() {
		return subscriptionDrillDrown;
	}

	public static void setSubscription(SubscriptionReportDrillDown subscriptionDrillDrown) {
		ObjectsBean.subscriptionDrillDrown = subscriptionDrillDrown;
	}

	public static void setpaidmedia(PaidMediaSetting pegapaidmedia) {
		// TODO Auto-generated method stub
		ObjectsBean.pegapaidmedia = pegapaidmedia;
	}

	public static PaidMediaSetting getpaidmedia() {
		// TODO Auto-generated method stub
		return pegapaidmedia;
	}

	public static void setPaidMediaAudiences(PaidMediaAudiences paidMediaAudiences) {
		ObjectsBean.paidMediaAudiences = paidMediaAudiences;
	}

	public static PaidMediaAudiences getPaidMediaAudiences() {
		return ObjectsBean.paidMediaAudiences;
	}

	public static void setImageLibrary(ImageLibrary imageLibrary) {
		ObjectsBean.imageLibrary = imageLibrary;
	}

	public static ImageLibrary getImageLibrary() {
		return ObjectsBean.imageLibrary;
	}

	public static void setImageCatalogDialog(ImageCatalogDialog imgCatalog) {
		ObjectsBean.imgCatalog = imgCatalog;
	}

	public static ImageCatalogDialog getImageCatalogDialog() {
		return ObjectsBean.imgCatalog;
	}

	public static void setCampaignName(String Campaign1) {
		ObjectsBean.Campaign1 = Campaign1;

	}

	public static void setCampaignName1(String Campaign2) {
		ObjectsBean.Campaign2 = Campaign2;

	}

	public static String getCampaignName() {

		return Campaign1;
	}

	public static String getCampaignName1() {

		return Campaign2;
	}
}
