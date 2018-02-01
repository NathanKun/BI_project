package org.talend.designer.codegen.translators.databases.amazon.redshift;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TAmazonRedshiftManageBeginJava
{
  protected static String nl;
  public static synchronized TAmazonRedshiftManageBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonRedshiftManageBeginJava result = new TAmazonRedshiftManageBeginJava();
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
  protected final String TEXT_13 = ");" + NL + "   \t" + NL + "\tcom.amazonaws.services.redshift.AmazonRedshiftClient client_";
  protected final String TEXT_14 = " = new com.amazonaws.services.redshift.AmazonRedshiftClient(credentials_";
  protected final String TEXT_15 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_16 = NL + "\tclient_";
  protected final String TEXT_17 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_18 = "));" + NL + "\t";
  protected final String TEXT_19 = NL + "\t" + NL + "\t";
  protected final String TEXT_20 = " " + NL + "\t\t\tfinal String decryptedPwd_";
  protected final String TEXT_21 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "        \tfinal String decryptedPwd_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = "; ";
  protected final String TEXT_26 = NL + "    \tcom.amazonaws.services.redshift.model.CreateClusterRequest request_";
  protected final String TEXT_27 = " = new com.amazonaws.services.redshift.model.CreateClusterRequest()" + NL + "    \t\t.withClusterIdentifier(";
  protected final String TEXT_28 = ")" + NL + "    \t\t" + NL + "    \t\t.withDBName(";
  protected final String TEXT_29 = ")" + NL + "    \t\t.withPort(new Integer(";
  protected final String TEXT_30 = "))" + NL + "    \t\t.withMasterUsername(";
  protected final String TEXT_31 = ")" + NL + "    \t\t.withMasterUserPassword(decryptedPwd_";
  protected final String TEXT_32 = ")" + NL + "    \t\t" + NL + "    \t\t.withNodeType(";
  protected final String TEXT_33 = ")" + NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_34 = NL + "    \t\t.withNumberOfNodes(";
  protected final String TEXT_35 = ")" + NL + "    \t\t";
  protected final String TEXT_36 = NL + "    \t\t.withClusterType(\"single-node\")" + NL + "    \t\t";
  protected final String TEXT_37 = NL + "    \t\t" + NL + "    \t\t//advanced settings" + NL + "    \t\t";
  protected final String TEXT_38 = NL + "    \t\t.withClusterParameterGroupName(";
  protected final String TEXT_39 = ")" + NL + "    \t\t";
  protected final String TEXT_40 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t.withClusterSubnetGroupName(";
  protected final String TEXT_42 = ")" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t.withPubliclyAccessible(true)" + NL + "    \t\t\t";
  protected final String TEXT_45 = NL + "    \t\t\t.withElasticIp(";
  protected final String TEXT_46 = ")" + NL + "    \t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t.withPubliclyAccessible(false)" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t.withAvailabilityZone(";
  protected final String TEXT_51 = ")" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t.withVpcSecurityGroupIds(";
  protected final String TEXT_54 = ".split(\",\"))" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "    \t;" + NL + "    " + NL + "    \tcom.amazonaws.services.redshift.model.Cluster result_";
  protected final String TEXT_56 = " = client_";
  protected final String TEXT_57 = ".createCluster(request_";
  protected final String TEXT_58 = ");" + NL + "    \t";
  protected final String TEXT_59 = NL + "    \tlog.info(\"";
  protected final String TEXT_60 = " - cluster status : \" + result_";
  protected final String TEXT_61 = ");" + NL + "    \t";
  protected final String TEXT_62 = NL + "    \tglobalMap.put(\"";
  protected final String TEXT_63 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_64 = ".getClusterIdentifier());" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_65 = NL + "    \t\tboolean clusterReady_";
  protected final String TEXT_66 = " = false;" + NL + "            System.out.println(\"Wating for cluster to become available.\");" + NL + "            while (!clusterReady_";
  protected final String TEXT_67 = ") {" + NL + "                com.amazonaws.services.redshift.model.DescribeClustersResult result2_";
  protected final String TEXT_68 = " = client_";
  protected final String TEXT_69 = ".describeClusters(" + NL + "                \tnew com.amazonaws.services.redshift.model.DescribeClustersRequest()" + NL + "                   \t\t.withClusterIdentifier(result_";
  protected final String TEXT_70 = ".getClusterIdentifier())" + NL + "                );" + NL + "                com.amazonaws.services.redshift.model.Cluster cluster_";
  protected final String TEXT_71 = " = result2_";
  protected final String TEXT_72 = ".getClusters().get(0);" + NL + "                String status_";
  protected final String TEXT_73 = " = cluster_";
  protected final String TEXT_74 = ".getClusterStatus();" + NL + "                if (\"available\".equalsIgnoreCase(status_";
  protected final String TEXT_75 = ")) {" + NL + "                    clusterReady_";
  protected final String TEXT_76 = " = true;" + NL + "                    globalMap.put(\"";
  protected final String TEXT_77 = "_ENDPOINT\", cluster_";
  protected final String TEXT_78 = ".getEndpoint().getAddress());" + NL + "                } else {" + NL + "                    System.out.print(\".\");" + NL + "                    Thread.sleep(2000);" + NL + "                }" + NL + "            }" + NL + "    \t";
  protected final String TEXT_79 = NL + "\t";
  protected final String TEXT_80 = NL + "    \tcom.amazonaws.services.redshift.model.DeleteClusterRequest request_";
  protected final String TEXT_81 = " = new com.amazonaws.services.redshift.model.DeleteClusterRequest()" + NL + "    \t\t.withClusterIdentifier(";
  protected final String TEXT_82 = ")" + NL + "    \t\t";
  protected final String TEXT_83 = NL + "    \t\t.withSkipFinalClusterSnapshot(false)" + NL + "    \t\t.withFinalClusterSnapshotIdentifier(";
  protected final String TEXT_84 = ")" + NL + "    \t\t";
  protected final String TEXT_85 = NL + "    \t\t.withSkipFinalClusterSnapshot(true)" + NL + "    \t\t";
  protected final String TEXT_86 = NL + "\t\t;" + NL + "    " + NL + "\t\tcom.amazonaws.services.redshift.model.Cluster result_";
  protected final String TEXT_87 = " = client_";
  protected final String TEXT_88 = ".deleteCluster(request_";
  protected final String TEXT_89 = ");" + NL + "\t\t";
  protected final String TEXT_90 = NL + "    \tlog.info(\"";
  protected final String TEXT_91 = " - cluster status : \" + result_";
  protected final String TEXT_92 = ");" + NL + "    \t";
  protected final String TEXT_93 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_94 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_95 = ".getClusterIdentifier());" + NL + "\t";
  protected final String TEXT_96 = NL + "\t\tcom.amazonaws.services.redshift.model.ModifyClusterRequest request_Modify_";
  protected final String TEXT_97 = " = " + NL + "\t\t\t\tnew com.amazonaws.services.redshift.model.ModifyClusterRequest()" + NL + "\t\t\t\t.withClusterIdentifier(";
  protected final String TEXT_98 = ").withNumberOfNodes(";
  protected final String TEXT_99 = ").withNodeType(";
  protected final String TEXT_100 = ");\t\t" + NL + "\t\t\t\t" + NL + "\t\tcom.amazonaws.services.redshift.model.Cluster result_";
  protected final String TEXT_101 = " = client_";
  protected final String TEXT_102 = ".modifyCluster(request_Modify_";
  protected final String TEXT_103 = ");" + NL + "\t\t";
  protected final String TEXT_104 = NL + "    \tlog.info(\"";
  protected final String TEXT_105 = " - cluster status : \" + result_";
  protected final String TEXT_106 = ");" + NL + "    \t";
  protected final String TEXT_107 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_108 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_109 = ".getClusterIdentifier());" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_110 = NL + "    \t\tboolean clusterReady_";
  protected final String TEXT_111 = " = false;" + NL + "            System.out.println(\"Wating for cluster to become available.\");" + NL + "            while (!clusterReady_";
  protected final String TEXT_112 = ") {" + NL + "                com.amazonaws.services.redshift.model.DescribeClustersResult result2_";
  protected final String TEXT_113 = " = client_";
  protected final String TEXT_114 = ".describeClusters(" + NL + "                \tnew com.amazonaws.services.redshift.model.DescribeClustersRequest()" + NL + "                   \t\t.withClusterIdentifier(result_";
  protected final String TEXT_115 = ".getClusterIdentifier())" + NL + "                );" + NL + "                com.amazonaws.services.redshift.model.Cluster cluster_";
  protected final String TEXT_116 = " = result2_";
  protected final String TEXT_117 = ".getClusters().get(0);" + NL + "                String status_";
  protected final String TEXT_118 = " = cluster_";
  protected final String TEXT_119 = ".getClusterStatus();" + NL + "                if (\"available\".equalsIgnoreCase(status_";
  protected final String TEXT_120 = ")) {" + NL + "                    clusterReady_";
  protected final String TEXT_121 = " = true;" + NL + "                    globalMap.put(\"";
  protected final String TEXT_122 = "_ENDPOINT\", cluster_";
  protected final String TEXT_123 = ".getEndpoint().getAddress());" + NL + "                } else {" + NL + "                    System.out.print(\".\");" + NL + "                    Thread.sleep(2000);" + NL + "                }" + NL + "            }" + NL + "    \t";
  protected final String TEXT_124 = NL + "\t\t" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_125 = NL + "\t\tcom.amazonaws.services.redshift.model.RestoreFromClusterSnapshotRequest request_";
  protected final String TEXT_126 = " = new com.amazonaws.services.redshift.model.RestoreFromClusterSnapshotRequest()" + NL + "    \t\t.withSnapshotIdentifier(";
  protected final String TEXT_127 = ")" + NL + "    \t\t.withClusterIdentifier(";
  protected final String TEXT_128 = ")" + NL + "    \t\t.withPort(new Integer(";
  protected final String TEXT_129 = "))" + NL + "    \t\t.withNodeType(";
  protected final String TEXT_130 = ")" + NL + "    \t\t" + NL + "    \t\t//advanced settings" + NL + "    \t\t";
  protected final String TEXT_131 = NL + "    \t\t.withSnapshotClusterIdentifier(";
  protected final String TEXT_132 = ")" + NL + "    \t\t";
  protected final String TEXT_133 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_134 = NL + "    \t\t.withClusterParameterGroupName(";
  protected final String TEXT_135 = ")" + NL + "    \t\t";
  protected final String TEXT_136 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t.withClusterSubnetGroupName(";
  protected final String TEXT_138 = ")" + NL + "\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t.withPubliclyAccessible(true)" + NL + "    \t\t\t";
  protected final String TEXT_141 = NL + "    \t\t\t.withElasticIp(";
  protected final String TEXT_142 = ")" + NL + "    \t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t.withPubliclyAccessible(false)" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t.withAvailabilityZone(";
  protected final String TEXT_147 = ")" + NL + "\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t.withVpcSecurityGroupIds(";
  protected final String TEXT_150 = ".split(\",\"))" + NL + "\t\t\t";
  protected final String TEXT_151 = NL + "\t\t;" + NL + "\t\tcom.amazonaws.services.redshift.model.Cluster result_";
  protected final String TEXT_152 = " = client_";
  protected final String TEXT_153 = ".restoreFromClusterSnapshot(request_";
  protected final String TEXT_154 = ");" + NL + "\t\t";
  protected final String TEXT_155 = NL + "    \tlog.info(\"";
  protected final String TEXT_156 = " - cluster status : \" + result_";
  protected final String TEXT_157 = ");" + NL + "    \t";
  protected final String TEXT_158 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_159 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_160 = ".getClusterIdentifier());" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_161 = NL + "    \t\tboolean clusterReady_";
  protected final String TEXT_162 = " = false;" + NL + "            System.out.println(\"Wating for cluster to become available.\");" + NL + "            while (!clusterReady_";
  protected final String TEXT_163 = ") {" + NL + "                com.amazonaws.services.redshift.model.DescribeClustersResult result2_";
  protected final String TEXT_164 = " = client_";
  protected final String TEXT_165 = ".describeClusters(" + NL + "                \tnew com.amazonaws.services.redshift.model.DescribeClustersRequest()" + NL + "                   \t\t.withClusterIdentifier(result_";
  protected final String TEXT_166 = ".getClusterIdentifier())" + NL + "                );" + NL + "                com.amazonaws.services.redshift.model.Cluster cluster_";
  protected final String TEXT_167 = " = result2_";
  protected final String TEXT_168 = ".getClusters().get(0);" + NL + "                String status_";
  protected final String TEXT_169 = " = cluster_";
  protected final String TEXT_170 = ".getClusterStatus();" + NL + "                " + NL + "                String restoreStatus_";
  protected final String TEXT_171 = " = cluster_";
  protected final String TEXT_172 = ".getRestoreStatus().getStatus();" + NL + "                " + NL + "                if (\"available\".equalsIgnoreCase(status_";
  protected final String TEXT_173 = ") && (\"completed\".equalsIgnoreCase(restoreStatus_";
  protected final String TEXT_174 = ") || \"failed\".equalsIgnoreCase(restoreStatus_";
  protected final String TEXT_175 = "))) {" + NL + "                    clusterReady_";
  protected final String TEXT_176 = " = true;" + NL + "                    globalMap.put(\"";
  protected final String TEXT_177 = "_ENDPOINT\", cluster_";
  protected final String TEXT_178 = ".getEndpoint().getAddress());" + NL + "                } else {" + NL + "                    System.out.print(\".\");" + NL + "                    Thread.sleep(2000);" + NL + "                }" + NL + "            }" + NL + "    \t";
  protected final String TEXT_179 = NL + "\t";
  protected final String TEXT_180 = NL + "\t\tcom.amazonaws.services.redshift.model.DeleteClusterSnapshotRequest request_";
  protected final String TEXT_181 = " = new com.amazonaws.services.redshift.model.DeleteClusterSnapshotRequest()" + NL + "    \t\t.withSnapshotIdentifier(";
  protected final String TEXT_182 = ")" + NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_183 = NL + "    \t\t.withSnapshotClusterIdentifier(";
  protected final String TEXT_184 = ")" + NL + "    \t\t";
  protected final String TEXT_185 = NL + "\t\t;" + NL + "\t\tcom.amazonaws.services.redshift.model.Snapshot result_";
  protected final String TEXT_186 = " = client_";
  protected final String TEXT_187 = ".deleteClusterSnapshot(request_";
  protected final String TEXT_188 = ");" + NL + "\t\t";
  protected final String TEXT_189 = NL + "    \tlog.info(\"";
  protected final String TEXT_190 = " - cluster status : \" + result_";
  protected final String TEXT_191 = ");" + NL + "    \t";
  protected final String TEXT_192 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_193 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_194 = ".getClusterIdentifier());" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	
	boolean create_snapshot_when_delete_cluster = "true".equals(ElementParameterParser.getValue(node, "__CREATE_SNAPSHOT_WHEN_DELETE_CLUSTER__"));
	String snapshot_id = ElementParameterParser.getValue(node, "__SNAPSHOT_ID__");
	String cluster_id = ElementParameterParser.getValue(node, "__CLUSTER_ID__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String port = ElementParameterParser.getValue(node, "__PORT__");
	String user = ElementParameterParser.getValue(node, "__USER__");
	String node_type = ElementParameterParser.getValue(node, "__NODE_TYPE__");
	String node_count = ElementParameterParser.getValue(node, "__NODE_COUNT__");
	
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String parameter_group_name = ElementParameterParser.getValue(node, "__PARAMETER_GROUP_NAME__");
	String subnet_group_name = ElementParameterParser.getValue(node, "__SUBNET_GROUP_NAME__");
	
	boolean publicly_accessible = "true".equals(ElementParameterParser.getValue(node, "__PUBLICLY_ACCESSIBLE__"));
	boolean set_public_ip_address = "true".equals(ElementParameterParser.getValue(node, "__SET_PUBLIC_IP_ADDRESS__"));
	String elastic_ip = ElementParameterParser.getValue(node, "__ELASTIC_IP__");
	
	String availability_zone = ElementParameterParser.getValue(node, "__AVAILABILITY_ZONE__");
	String vpc_security_groupids = ElementParameterParser.getValue(node, "__VPC_SECURITY_GROUPIDS__");
	
	boolean wait_for_cluster_ready = "true".equals(ElementParameterParser.getValue(node, "__WAIT_FOR_CLUSTER_READY__"));
	
	String original_cluster_id_of_snapshot = ElementParameterParser.getValue(node, "__ORIGINAL_CLUSTER_ID_OF_SNAPSHOT__");
	
	class ParameterUtil {
		
		boolean isValid(String parameterValue) {
			return parameterValue!=null && !parameterValue.isEmpty() && !"\"\"".equals(parameterValue);
		}
	}
	
	ParameterUtil parameterUtil = new ParameterUtil();

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
    
	if("CREATE_CLUSTER".equals(action)) {
		passwordFieldName = "__PASS__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
		
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_22);
    
        } else {
        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    
        }
        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(node_type);
    stringBuffer.append(TEXT_33);
    
    		if(new Integer(node_count) > 1){
    		
    stringBuffer.append(TEXT_34);
    stringBuffer.append(node_count);
    stringBuffer.append(TEXT_35);
    
    		} else {
    		
    stringBuffer.append(TEXT_36);
    
    		}
    		
    stringBuffer.append(TEXT_37);
    if(parameterUtil.isValid(parameter_group_name)) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(parameter_group_name);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    if(parameterUtil.isValid(subnet_group_name)) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(subnet_group_name);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    
			if(publicly_accessible) {
			
    stringBuffer.append(TEXT_44);
    if(set_public_ip_address) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(elastic_ip);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    
			} else {
			
    stringBuffer.append(TEXT_48);
    
			}
			
    stringBuffer.append(TEXT_49);
    if(parameterUtil.isValid(availability_zone)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(availability_zone);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    if(parameterUtil.isValid(vpc_security_groupids)) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(vpc_security_groupids);
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
    	if(wait_for_cluster_ready) {
    	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
    	}
    	
    stringBuffer.append(TEXT_79);
    
	} else if("DELETE_CLUSTER".equals(action)) {
	
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_82);
    if(create_snapshot_when_delete_cluster) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(snapshot_id);
    stringBuffer.append(TEXT_84);
    } else {
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
	} else if("RESIZE_CLUSTER".equals(action)) {
	
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(node_count);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(node_type);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
    	if(wait_for_cluster_ready) {
    	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
    	}
    	
    stringBuffer.append(TEXT_124);
    
	} else if("RESTORE_FROM_SNAPSHOT".equals(action)) {
	
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(snapshot_id);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(node_type);
    stringBuffer.append(TEXT_130);
    if(parameterUtil.isValid(original_cluster_id_of_snapshot)) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(original_cluster_id_of_snapshot);
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    if(parameterUtil.isValid(parameter_group_name)) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(parameter_group_name);
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    if(parameterUtil.isValid(subnet_group_name)) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(subnet_group_name);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    
			if(publicly_accessible) {
			
    stringBuffer.append(TEXT_140);
    if(set_public_ip_address) {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(elastic_ip);
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    
			} else {
			
    stringBuffer.append(TEXT_144);
    
			}
			
    stringBuffer.append(TEXT_145);
    if(parameterUtil.isValid(availability_zone)) {
    stringBuffer.append(TEXT_146);
    stringBuffer.append(availability_zone);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    if(parameterUtil.isValid(vpc_security_groupids)) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(vpc_security_groupids);
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
    	if(wait_for_cluster_ready) {
    	
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
    	}
    	
    stringBuffer.append(TEXT_179);
    
	} else if("DELETE_SNAPSHOT".equals(action)) {
	
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(snapshot_id);
    stringBuffer.append(TEXT_182);
    if(parameterUtil.isValid(original_cluster_id_of_snapshot)) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(original_cluster_id_of_snapshot);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    }
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
	}
	
    return stringBuffer.toString();
  }
}
