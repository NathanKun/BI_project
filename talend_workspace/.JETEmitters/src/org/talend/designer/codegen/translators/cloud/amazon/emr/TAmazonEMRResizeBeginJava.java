package org.talend.designer.codegen.translators.cloud.amazon.emr;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TAmazonEMRResizeBeginJava
{
  protected static String nl;
  public static synchronized TAmazonEMRResizeBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonEMRResizeBeginJava result = new TAmazonEMRResizeBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t        " + NL + "\t";
  protected final String TEXT_3 = NL + "\t" + NL + "\t";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "   \t" + NL + "   \tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_11 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_12 = ",decryptedPassword_";
  protected final String TEXT_13 = ");" + NL + "   \t" + NL + "\tcom.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient emr_";
  protected final String TEXT_14 = " = new com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient(credentials_";
  protected final String TEXT_15 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_16 = NL + "\temr_";
  protected final String TEXT_17 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_18 = "));" + NL + "\t";
  protected final String TEXT_19 = NL + NL + "\tboolean isTaskGroup_";
  protected final String TEXT_20 = " = true;" + NL + "\t" + NL + "\t";
  protected final String TEXT_21 = "\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig config_";
  protected final String TEXT_22 = " = new com.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig();" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\t\tconfig_";
  protected final String TEXT_24 = ".setMarket(\"SPOT\");" + NL + "\t\t\tconfig_";
  protected final String TEXT_25 = ".setBidPrice(";
  protected final String TEXT_26 = ");" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest request_";
  protected final String TEXT_28 = " = new com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest()" + NL + "\t\t\t.withJobFlowId(";
  protected final String TEXT_29 = ")" + NL + "\t\t\t.withInstanceGroups(config_";
  protected final String TEXT_30 = NL + "\t\t\t\t.withInstanceCount(";
  protected final String TEXT_31 = ")" + NL + "\t\t\t\t.withInstanceRole(\"TASK\")" + NL + "\t\t\t\t.withInstanceType(";
  protected final String TEXT_32 = ")" + NL + "\t\t\t\t.withName(";
  protected final String TEXT_33 = ")" + NL + "\t\t\t\t)" + NL + "\t\t;" + NL + "\t\t" + NL + " \t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult result_";
  protected final String TEXT_34 = " = emr_";
  protected final String TEXT_35 = ".addInstanceGroups(request_";
  protected final String TEXT_36 = ");\t\t" + NL + "\t\tif(result_";
  protected final String TEXT_37 = ".getInstanceGroupIds()!=null && result_";
  protected final String TEXT_38 = ".getInstanceGroupIds().size()>0){" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_39 = "_TASK_GROUP_ID\", result_";
  protected final String TEXT_40 = ".getInstanceGroupIds().get(0));" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_41 = "_TASK_GROUP_NAME\", ";
  protected final String TEXT_42 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_43 = NL + "\t" + NL + "\t\t//Validate if the instance group type is core" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest listRequest_";
  protected final String TEXT_44 = " = new com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest()" + NL + "\t\t\t.withClusterId(";
  protected final String TEXT_45 = ");" + NL + "\t\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult listResult_";
  protected final String TEXT_46 = " = emr_";
  protected final String TEXT_47 = ".listInstanceGroups(listRequest_";
  protected final String TEXT_48 = ");" + NL + "\t\t " + NL + "\t\tList<com.amazonaws.services.elasticmapreduce.model.InstanceGroup> groupList_";
  protected final String TEXT_49 = " = listResult_";
  protected final String TEXT_50 = ".getInstanceGroups();" + NL + "\t" + NL + "\t\tjava.util.Iterator<com.amazonaws.services.elasticmapreduce.model.InstanceGroup> iterator_";
  protected final String TEXT_51 = " = groupList_";
  protected final String TEXT_52 = ".iterator();" + NL + "\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.InstanceGroup instanceGroup_";
  protected final String TEXT_53 = " = null;" + NL + "\t" + NL + "\t\twhile (iterator_";
  protected final String TEXT_54 = ".hasNext()) {" + NL + "" + NL + "\t\t\tinstanceGroup_";
  protected final String TEXT_55 = " = iterator_";
  protected final String TEXT_56 = ".next();" + NL + "\t\t\tString instanceGroupId_";
  protected final String TEXT_57 = " = instanceGroup_";
  protected final String TEXT_58 = ".getId();" + NL + "\t\t\tString instanceGroupType_";
  protected final String TEXT_59 = " = instanceGroup_";
  protected final String TEXT_60 = ".getInstanceGroupType();" + NL + "\t\t\tif(!instanceGroupType_";
  protected final String TEXT_61 = ".equalsIgnoreCase(\"TASK\") && instanceGroupId_";
  protected final String TEXT_62 = ".equals(";
  protected final String TEXT_63 = ")){" + NL + "\t\t\t\tSystem.err.println(\"Not support resizing master or core instance group: \" + (";
  protected final String TEXT_64 = "));" + NL + "\t\t\t\tisTaskGroup_";
  protected final String TEXT_65 = " = false;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t//Resize instance group " + NL + "\t\tif(isTaskGroup_";
  protected final String TEXT_66 = "){" + NL + "\t\t\tcom.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest request_";
  protected final String TEXT_67 = " = new com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest()" + NL + "\t\t\t\t.withInstanceGroups(new com.amazonaws.services.elasticmapreduce.model.InstanceGroupModifyConfig()" + NL + "\t\t\t\t\t.withInstanceCount(";
  protected final String TEXT_68 = ")" + NL + "\t\t\t\t\t.withInstanceGroupId(";
  protected final String TEXT_69 = ")" + NL + "\t\t\t\t\t);\t" + NL + "\t\t\temr_";
  protected final String TEXT_70 = ".modifyInstanceGroups(request_";
  protected final String TEXT_71 = ");\t\t\t\t" + NL + "\t\t}" + NL + "" + NL + "\t";
  protected final String TEXT_72 = NL + NL + "\t";
  protected final String TEXT_73 = NL + "\t\tif(isTaskGroup_";
  protected final String TEXT_74 = "){" + NL + "\t\t\tboolean clusterReady_";
  protected final String TEXT_75 = " = false;" + NL + "\t\t\tSystem.out.println(\"Wating for cluster to become available.\");" + NL + "\t\t\twhile (!clusterReady_";
  protected final String TEXT_76 = ") {" + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.DescribeClusterResult result2_";
  protected final String TEXT_77 = " = emr_";
  protected final String TEXT_78 = ".describeCluster(" + NL + "\t\t\t\t\tnew com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest()" + NL + "\t\t\t\t\t\t.withClusterId(";
  protected final String TEXT_79 = ")" + NL + "\t\t\t\t);" + NL + "\t\t\t\tString status_";
  protected final String TEXT_80 = " = result2_";
  protected final String TEXT_81 = ".getCluster().getStatus().getState();" + NL + "\t\t\t\tif (\"WAITING\".equalsIgnoreCase(status_";
  protected final String TEXT_82 = ") || \"RUNNING\".equalsIgnoreCase(status_";
  protected final String TEXT_83 = ")) {" + NL + "\t\t\t\t\tclusterReady_";
  protected final String TEXT_84 = " = true;" + NL + "\t\t\t\t} else if(\"TERMINATED_WITH_ERRORS\".equalsIgnoreCase(status_";
  protected final String TEXT_85 = ") || \"TERMINATED\".equalsIgnoreCase(status_";
  protected final String TEXT_86 = ")) {" + NL + "\t\t\t\t\tclusterReady_";
  protected final String TEXT_87 = " = true;" + NL + "\t\t\t\t\tSystem.err.println(\"Fail to start the cluster.\");" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tSystem.out.print(\".\");" + NL + "\t\t\t\t\tThread.sleep(2000);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_88 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	String cluster_id = ElementParameterParser.getValue(node, "__CLUSTER_ID__");
	String group_name = ElementParameterParser.getValue(node, "__GROUP_NAME__");
	String group_id = ElementParameterParser.getValue(node, "__GROUP_ID__");
	
	boolean request_spot = "true".equals(ElementParameterParser.getValue(node, "__REQUEST_SPOT__"));
	String bid_price = ElementParameterParser.getValue(node, "__BID_PRICE__");
	
	int instance_count = Integer.parseInt(ElementParameterParser.getValue(node, "__INSTANCE_COUNT__"));
	
	String task_instance_type = ElementParameterParser.getValue(node, "__TASK_INSTANCE_TYPE__");
		
	boolean wait_for_cluster_ready = false;
	
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	

    stringBuffer.append(TEXT_2);
    
	String passwordFieldName = "__SECRET_KEY__";
	
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_18);
    
	}
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
	if("ADD_TASK_INSTANCE_GROUP".equals(action)) {
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
		if(request_spot) {				
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(bid_price );
    stringBuffer.append(TEXT_26);
    
		}
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(instance_count);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(task_instance_type);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(group_name);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(group_name);
    stringBuffer.append(TEXT_42);
    
	} else if ("RESIZE_TASK_INSTANCE_GROUP".equals(action)) {
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(group_id);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(group_id);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(instance_count);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(group_id);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
	}
	
    stringBuffer.append(TEXT_72);
    
	if(wait_for_cluster_ready) {
	
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
	}
	
    stringBuffer.append(TEXT_88);
    return stringBuffer.toString();
  }
}
