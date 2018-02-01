package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMOutputBeginJava
{
  protected static String nl;
  public static synchronized TMDMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMOutputBeginJava result = new TMDMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            StringBuilder ";
  protected final String TEXT_11 = " = new StringBuilder();";
  protected final String TEXT_12 = NL + "            ";
  protected final String TEXT_13 = ".append(\"Parameters:\");";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"";
  protected final String TEXT_16 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_17 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_18 = NL + "                    ";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "                ";
  protected final String TEXT_23 = ".append(\" | \");";
  protected final String TEXT_24 = NL + "            StringBuilder ";
  protected final String TEXT_25 = " = new StringBuilder();    ";
  protected final String TEXT_26 = NL + "                    ";
  protected final String TEXT_27 = ".append(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                    if(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " == null){";
  protected final String TEXT_33 = NL + "                        ";
  protected final String TEXT_34 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_35 = NL + "                        ";
  protected final String TEXT_36 = ".append(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");" + NL + "                    }   ";
  protected final String TEXT_39 = NL + "                ";
  protected final String TEXT_40 = ".append(\"|\");";
  protected final String TEXT_41 = NL + "int nb_line_";
  protected final String TEXT_42 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_43 = " = 0;";
  protected final String TEXT_44 = NL + "    ";
  protected final String TEXT_45 = NL + "        class Util_";
  protected final String TEXT_46 = "{" + NL + "            public org.talend.mdm.webservice.WSUpdateMetadataItem makeUpdateMeteItm(String taskID,org.talend.mdm.webservice.WSItemPK wspk){" + NL + "                org.talend.mdm.webservice.WSUpdateMetadataItem wsUpdateMetadataItem = new org.talend.mdm.webservice.WSUpdateMetadataItem();" + NL + "                wsUpdateMetadataItem.setTaskId(taskID);" + NL + "                wsUpdateMetadataItem.setWsItemPK(wspk);" + NL + "                return wsUpdateMetadataItem;" + NL + "            }" + NL + "            public org.talend.mdm.webservice.WSUpdateMetadataItem[] makeUpdateMeteItms(java.util.List<String> taskIDs,org.talend.mdm.webservice.WSItemPK[] wspks){" + NL + "                java.util.List<org.talend.mdm.webservice.WSUpdateMetadataItem> wsUpdateMetadataItems = new java.util.ArrayList<org.talend.mdm.webservice.WSUpdateMetadataItem>();" + NL + "                int i = 0;" + NL + "                for(org.talend.mdm.webservice.WSItemPK wspk : wspks){" + NL + "                    wsUpdateMetadataItems.add(makeUpdateMeteItm(taskIDs.get(i),wspk));" + NL + "                    i++;" + NL + "                }" + NL + "                return wsUpdateMetadataItems.toArray(new org.talend.mdm.webservice.WSUpdateMetadataItem[wsUpdateMetadataItems.size()]);" + NL + "            }" + NL + "        }" + NL + "        Util_";
  protected final String TEXT_47 = " util_";
  protected final String TEXT_48 = " = new Util_";
  protected final String TEXT_49 = "();";
  protected final String TEXT_50 = NL + "            java.util.List <org.talend.mdm.webservice.WSPutItemWithReport> miList_";
  protected final String TEXT_51 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItemWithReport>();";
  protected final String TEXT_52 = NL + "            java.util.List <org.talend.mdm.webservice.WSPutItem> miList_";
  protected final String TEXT_53 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItem>();";
  protected final String TEXT_54 = NL + "            java.util.List<String> taskIDs_";
  protected final String TEXT_55 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = NL + "    String murl_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "    if(murl_";
  protected final String TEXT_60 = ".endsWith(\"?wsdl\")) {" + NL + "       murl_";
  protected final String TEXT_61 = " = murl_";
  protected final String TEXT_62 = ".substring(0, murl_";
  protected final String TEXT_63 = ".length() - 5);" + NL + "    }" + NL;
  protected final String TEXT_64 = NL + "    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_65 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_66 = " = service_service_";
  protected final String TEXT_67 = ".getTMDMPort();" + NL + "    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_68 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_69 = ";" + NL + "    java.util.Map<String, Object> context_";
  protected final String TEXT_70 = " = stub_";
  protected final String TEXT_71 = ".getRequestContext();" + NL + "    context_";
  protected final String TEXT_72 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "    context_";
  protected final String TEXT_73 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, ";
  protected final String TEXT_74 = ");" + NL + "    context_";
  protected final String TEXT_75 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_78 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = "; ";
  protected final String TEXT_83 = NL + "    context_";
  protected final String TEXT_84 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, decryptedPassword_";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "    String murl_";
  protected final String TEXT_87 = " = (String)globalMap.get(\"mdmUrl_";
  protected final String TEXT_88 = "\");" + NL + "    if(murl_";
  protected final String TEXT_89 = ".endsWith(\"?wsdl\")) {" + NL + "        murl_";
  protected final String TEXT_90 = " = murl_";
  protected final String TEXT_91 = ".substring(0, murl_";
  protected final String TEXT_92 = ".length() - 5);" + NL + "    }" + NL + "    String username_";
  protected final String TEXT_93 = " = (String)globalMap.get(\"username_";
  protected final String TEXT_94 = "\");" + NL + "    String password_";
  protected final String TEXT_95 = " = (String)globalMap.get(\"password_";
  protected final String TEXT_96 = "\");" + NL;
  protected final String TEXT_97 = NL + "    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_98 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_99 = " = service_service_";
  protected final String TEXT_100 = ".getTMDMPort();" + NL + "    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_101 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_102 = ";" + NL + "    java.util.Map<String, Object> context_";
  protected final String TEXT_103 = " = stub_";
  protected final String TEXT_104 = ".getRequestContext();" + NL + "    context_";
  protected final String TEXT_105 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "    context_";
  protected final String TEXT_106 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_107 = ");" + NL + "    context_";
  protected final String TEXT_108 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username_";
  protected final String TEXT_109 = ");" + NL + "    context_";
  protected final String TEXT_110 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password_";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "    String connKey_";
  protected final String TEXT_113 = " = \"";
  protected final String TEXT_114 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "    String transKey_";
  protected final String TEXT_115 = " = \"";
  protected final String TEXT_116 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_117 = " = (org.talend.mdm.webservice.TMDMService)globalMap.get(connKey_";
  protected final String TEXT_118 = ");" + NL + "    if(service_";
  protected final String TEXT_119 = " == null){" + NL + "        String murl_";
  protected final String TEXT_120 = " = (String)globalMap.get(\"mdmUrl_";
  protected final String TEXT_121 = "\");" + NL + "        if(murl_";
  protected final String TEXT_122 = ".endsWith(\"?wsdl\")) {" + NL + "            murl_";
  protected final String TEXT_123 = " = murl_";
  protected final String TEXT_124 = ".substring(0, murl_";
  protected final String TEXT_125 = ".length() - 5);" + NL + "        }" + NL + "        String username_";
  protected final String TEXT_126 = " = (String)globalMap.get(\"username_";
  protected final String TEXT_127 = "\");" + NL + "        String password_";
  protected final String TEXT_128 = " = (String)globalMap.get(\"password_";
  protected final String TEXT_129 = "\");" + NL;
  protected final String TEXT_130 = NL + "        org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_131 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "        service_";
  protected final String TEXT_132 = " = service_service_";
  protected final String TEXT_133 = ".getTMDMPort();" + NL + "        javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_134 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_135 = ";" + NL + "        java.util.Map<String, Object> context_";
  protected final String TEXT_136 = " = stub_";
  protected final String TEXT_137 = ".getRequestContext();" + NL + "        context_";
  protected final String TEXT_138 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, true);" + NL + "        context_";
  protected final String TEXT_139 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_140 = ");" + NL + "        context_";
  protected final String TEXT_141 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username_";
  protected final String TEXT_142 = ");" + NL + "        context_";
  protected final String TEXT_143 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password_";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + NL + "        if((Boolean)globalMap.get(\"useTransaction_";
  protected final String TEXT_146 = "\")) {" + NL + "            String turl_";
  protected final String TEXT_147 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getMDMTransactionURL(murl_";
  protected final String TEXT_148 = ", true);" + NL + "            com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_149 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(transKey_";
  protected final String TEXT_150 = ");" + NL + "            if(mdmTransaction_";
  protected final String TEXT_151 = " == null){" + NL + "                if((Boolean)globalMap.get(\"useClientTranId_";
  protected final String TEXT_152 = "\")){" + NL + "                    String sessionID_";
  protected final String TEXT_153 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getSessionID(turl_";
  protected final String TEXT_154 = ",username_";
  protected final String TEXT_155 = ",password_";
  protected final String TEXT_156 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_157 = " = new com.talend.mdm.transaction.client.MDMTransaction();" + NL + "                    mdmTransaction_";
  protected final String TEXT_158 = ".setUrl(turl_";
  protected final String TEXT_159 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_160 = ".setId(\"";
  protected final String TEXT_161 = "_\" + java.util.UUID.randomUUID());" + NL + "                    mdmTransaction_";
  protected final String TEXT_162 = ".setUsername(username_";
  protected final String TEXT_163 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_164 = ".setPassword(password_";
  protected final String TEXT_165 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_166 = ".setSessionId(sessionID_";
  protected final String TEXT_167 = ");" + NL + "                }else{";
  protected final String TEXT_168 = NL + "                    mdmTransaction_";
  protected final String TEXT_169 = " = com.talend.mdm.transaction.client.MDMTransactionClient.newTransaction(turl_";
  protected final String TEXT_170 = ",username_";
  protected final String TEXT_171 = ",password_";
  protected final String TEXT_172 = ");" + NL + "                }" + NL + "                java.util.List<org.apache.cxf.headers.Header> soapHeaders_";
  protected final String TEXT_173 = " = new java.util.ArrayList<org.apache.cxf.headers.Header>();" + NL + "                javax.xml.namespace.QName qName_";
  protected final String TEXT_174 = " = new javax.xml.namespace.QName(\"http://www.talend.com/mdm\", \"transaction-id\");" + NL + "                org.apache.cxf.databinding.DataBinding dataBinding_";
  protected final String TEXT_175 = " = new org.apache.cxf.jaxb.JAXBDataBinding(String.class);" + NL + "                soapHeaders_";
  protected final String TEXT_176 = ".add(new org.apache.cxf.headers.Header(qName_";
  protected final String TEXT_177 = ", mdmTransaction_";
  protected final String TEXT_178 = ".getId(), dataBinding_";
  protected final String TEXT_179 = "));" + NL + "                context_";
  protected final String TEXT_180 = ".put(org.apache.cxf.headers.Header.HEADER_LIST, soapHeaders_";
  protected final String TEXT_181 = ");" + NL + "" + NL + "                java.util.Map<String, java.util.List<String>> httpHeaders_";
  protected final String TEXT_182 = " = new java.util.HashMap<String, java.util.List<String>>();" + NL + "                String cookie_";
  protected final String TEXT_183 = " = com.talend.mdm.transaction.client.MDMTransaction.getStickySession() + \"=\" + mdmTransaction_";
  protected final String TEXT_184 = ".getSessionId();" + NL + "                httpHeaders_";
  protected final String TEXT_185 = ".put(\"Cookie\", java.util.Arrays.asList(cookie_";
  protected final String TEXT_186 = "));" + NL + "                context_";
  protected final String TEXT_187 = ".put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, httpHeaders_";
  protected final String TEXT_188 = ");" + NL + "" + NL + "                globalMap.put(transKey_";
  protected final String TEXT_189 = ", mdmTransaction_";
  protected final String TEXT_190 = ");";
  protected final String TEXT_191 = NL + "            }" + NL + "        }" + NL + "        service_";
  protected final String TEXT_192 = ".ping(new org.talend.mdm.webservice.WSPing());";
  protected final String TEXT_193 = NL + "        globalMap.put(connKey_";
  protected final String TEXT_194 = ", service_";
  protected final String TEXT_195 = ");" + NL + "    }";
  protected final String TEXT_196 = NL + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_197 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_198 = " + \"";
  protected final String TEXT_199 = "\");" + NL + "org.talend.mdm.webservice.WSDataModelPK dataModel_";
  protected final String TEXT_200 = " = new org.talend.mdm.webservice.WSDataModelPK(";
  protected final String TEXT_201 = ");" + NL + "" + NL + "String input_";
  protected final String TEXT_202 = ";" + NL + "" + NL + "java.util.List<org.talend.mdm.webservice.WSItemPK> wspks_";
  protected final String TEXT_203 = ";" + NL + "org.talend.mdm.webservice.WSItemPK wspk_";
  protected final String TEXT_204 = ";";
  protected final String TEXT_205 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_17);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_21);
    
                }   
                
    stringBuffer.append(TEXT_22);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_23);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_25);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
                }else{
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    
                }
                
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
LogUtil logUtil = new LogUtil(node);
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
if(destination!=null && !"".equals(destination)){
    cid = destination;
}

boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String conn = "TMDMService_" + connection;
String trans = "mdmTrans_" + connection;
String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
String username = ElementParameterParser.getValue(node, "__USERNAME__");

String dataModel = ElementParameterParser.getValue(node, "__DATAMODEL__");
String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
boolean isProvisioning = "\"PROVISIONING\"".equalsIgnoreCase(dataCluster);

boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));

boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
boolean usePartialDelete = ("true").equals(ElementParameterParser.getValue(node,"__PARTIAL_DELETE__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    if(!usePartialUpdate){
    stringBuffer.append(TEXT_44);
    if(addTaskID){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    }
    if(isMassInsert){
        if(!isStaging && withReport){
     logUtil.debug("\"Put item with report to MDM server.\"");
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
        }else{
     logUtil.debug("\"Put item to staging data.\"");
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
        }
        if(addTaskID){
    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
        }
    }
}
    stringBuffer.append(TEXT_56);
    if(!useExistingConn){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
     String passwordFieldName = "__PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_79);
    } else {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    }else if(isProvisioning){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_96);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    }else{
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(trans);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_129);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
     logUtil.debug("\"Got service successfully with key=\" + connKey_" + cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
     logUtil.debug("\"Attempt to get a remote transaction from url: \" + murl_" + cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
     logUtil.debug("\"Got transaction successfully with key=\" + transKey_" + cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    //For TDI-26109
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(dataModel );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(TEXT_205);
    return stringBuffer.toString();
  }
}
