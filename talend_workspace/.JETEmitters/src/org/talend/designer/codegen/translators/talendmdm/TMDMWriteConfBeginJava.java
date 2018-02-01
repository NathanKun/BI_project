package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMDMWriteConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfBeginJava result = new TMDMWriteConfBeginJava();
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
  protected final String TEXT_41 = NL + NL + "int nb_line_";
  protected final String TEXT_42 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_43 = " = 0;";
  protected final String TEXT_44 = NL + "        class Util_";
  protected final String TEXT_45 = "{" + NL + "            public org.talend.mdm.webservice.WSUpdateMetadataItem makeUpdateMeteItm(String taskID,org.talend.mdm.webservice.WSItemPK wspk){" + NL + "                org.talend.mdm.webservice.WSUpdateMetadataItem wsUpdateMetadataItem = new org.talend.mdm.webservice.WSUpdateMetadataItem();" + NL + "                wsUpdateMetadataItem.setTaskId(taskID);" + NL + "                wsUpdateMetadataItem.setWsItemPK(wspk);" + NL + "                return wsUpdateMetadataItem;" + NL + "            }" + NL + "            public org.talend.mdm.webservice.WSUpdateMetadataItem[] makeUpdateMeteItms(java.util.List<String> taskIDs,org.talend.mdm.webservice.WSItemPK[] wspks){" + NL + "                java.util.List<org.talend.mdm.webservice.WSUpdateMetadataItem> wsUpdateMetadataItems = new java.util.ArrayList<org.talend.mdm.webservice.WSUpdateMetadataItem>();" + NL + "                int i = 0;" + NL + "                for(org.talend.mdm.webservice.WSItemPK wspk : wspks){" + NL + "                    wsUpdateMetadataItems.add(makeUpdateMeteItm(taskIDs.get(i),wspk));" + NL + "                    i++;" + NL + "                }" + NL + "                return wsUpdateMetadataItems.toArray(new org.talend.mdm.webservice.WSUpdateMetadataItem[wsUpdateMetadataItems.size()]);" + NL + "            }" + NL + "        }" + NL + "        Util_";
  protected final String TEXT_46 = " util_";
  protected final String TEXT_47 = " = new Util_";
  protected final String TEXT_48 = "();";
  protected final String TEXT_49 = NL + "            java.util.List <org.talend.mdm.webservice.WSPutItemWithReport> miList_";
  protected final String TEXT_50 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItemWithReport>();";
  protected final String TEXT_51 = NL + "            java.util.List <org.talend.mdm.webservice.WSPutItem> miList_";
  protected final String TEXT_52 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItem>();";
  protected final String TEXT_53 = NL + "            java.util.List<String> taskIDs_";
  protected final String TEXT_54 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL + "    String murl_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ";" + NL + "    if(murl_";
  protected final String TEXT_59 = ".endsWith(\"?wsdl\")) {" + NL + "       murl_";
  protected final String TEXT_60 = " = murl_";
  protected final String TEXT_61 = ".substring(0, murl_";
  protected final String TEXT_62 = ".length() - 5);" + NL + "    }";
  protected final String TEXT_63 = NL + "    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_64 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_65 = " = service_service_";
  protected final String TEXT_66 = ".getTMDMPort();" + NL + "    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_67 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_68 = ";" + NL + "    java.util.Map<String, Object> context_";
  protected final String TEXT_69 = " = stub_";
  protected final String TEXT_70 = ".getRequestContext();" + NL + "    context_";
  protected final String TEXT_71 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "    context_";
  protected final String TEXT_72 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, ";
  protected final String TEXT_73 = ");" + NL + "    context_";
  protected final String TEXT_74 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_77 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = "; ";
  protected final String TEXT_82 = NL + "    context_";
  protected final String TEXT_83 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, decryptedPassword_";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "    String murl_";
  protected final String TEXT_86 = " = (String)globalMap.get(\"mdmUrl_";
  protected final String TEXT_87 = "\");" + NL + "    if(murl_";
  protected final String TEXT_88 = ".endsWith(\"?wsdl\")) {" + NL + "        murl_";
  protected final String TEXT_89 = " = murl_";
  protected final String TEXT_90 = ".substring(0, murl_";
  protected final String TEXT_91 = ".length() - 5);" + NL + "    }" + NL + "    String username_";
  protected final String TEXT_92 = " = (String)globalMap.get(\"username_";
  protected final String TEXT_93 = "\");" + NL + "    String password_";
  protected final String TEXT_94 = " = (String)globalMap.get(\"password_";
  protected final String TEXT_95 = "\");" + NL;
  protected final String TEXT_96 = NL + "    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_97 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_98 = " = service_service_";
  protected final String TEXT_99 = ".getTMDMPort();" + NL + "    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_100 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_101 = ";" + NL + "    java.util.Map<String, Object> context_";
  protected final String TEXT_102 = " = stub_";
  protected final String TEXT_103 = ".getRequestContext();" + NL + "    context_";
  protected final String TEXT_104 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "    context_";
  protected final String TEXT_105 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_106 = ");" + NL + "    context_";
  protected final String TEXT_107 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username_";
  protected final String TEXT_108 = ");" + NL + "    context_";
  protected final String TEXT_109 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password_";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "    String connKey_";
  protected final String TEXT_112 = " = \"";
  protected final String TEXT_113 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "    String transKey_";
  protected final String TEXT_114 = " = \"";
  protected final String TEXT_115 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_116 = " = (org.talend.mdm.webservice.TMDMService)globalMap.get(connKey_";
  protected final String TEXT_117 = ");" + NL + "    if(service_";
  protected final String TEXT_118 = " == null){" + NL + "        String murl_";
  protected final String TEXT_119 = " = (String)globalMap.get(\"mdmUrl_";
  protected final String TEXT_120 = "\");" + NL + "        if(murl_";
  protected final String TEXT_121 = ".endsWith(\"?wsdl\")) {" + NL + "            murl_";
  protected final String TEXT_122 = " = murl_";
  protected final String TEXT_123 = ".substring(0, murl_";
  protected final String TEXT_124 = ".length() - 5);" + NL + "        }" + NL + "        String username_";
  protected final String TEXT_125 = " = (String)globalMap.get(\"username_";
  protected final String TEXT_126 = "\");" + NL + "        String password_";
  protected final String TEXT_127 = " = (String)globalMap.get(\"password_";
  protected final String TEXT_128 = "\");" + NL;
  protected final String TEXT_129 = NL + "        org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_130 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "        service_";
  protected final String TEXT_131 = " = service_service_";
  protected final String TEXT_132 = ".getTMDMPort();" + NL + "        javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_133 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_134 = ";" + NL + "        java.util.Map<String, Object> context_";
  protected final String TEXT_135 = " = stub_";
  protected final String TEXT_136 = ".getRequestContext();" + NL + "        context_";
  protected final String TEXT_137 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, true);" + NL + "        context_";
  protected final String TEXT_138 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_139 = ");" + NL + "        context_";
  protected final String TEXT_140 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username_";
  protected final String TEXT_141 = ");" + NL + "        context_";
  protected final String TEXT_142 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password_";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = NL + NL + "        if((Boolean)globalMap.get(\"useTransaction_";
  protected final String TEXT_145 = "\")) {" + NL + "            String turl_";
  protected final String TEXT_146 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getMDMTransactionURL(murl_";
  protected final String TEXT_147 = ", true);" + NL + "            com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_148 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(transKey_";
  protected final String TEXT_149 = ");" + NL + "            if(mdmTransaction_";
  protected final String TEXT_150 = " == null){" + NL + "                if((Boolean)globalMap.get(\"useClientTranId_";
  protected final String TEXT_151 = "\")){" + NL + "                    String sessionID_";
  protected final String TEXT_152 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getSessionID(turl_";
  protected final String TEXT_153 = ",username_";
  protected final String TEXT_154 = ",password_";
  protected final String TEXT_155 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_156 = " = new com.talend.mdm.transaction.client.MDMTransaction();" + NL + "                    mdmTransaction_";
  protected final String TEXT_157 = ".setUrl(turl_";
  protected final String TEXT_158 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_159 = ".setId(\"";
  protected final String TEXT_160 = "_\" + java.util.UUID.randomUUID());" + NL + "                    mdmTransaction_";
  protected final String TEXT_161 = ".setUsername(username_";
  protected final String TEXT_162 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_163 = ".setPassword(password_";
  protected final String TEXT_164 = ");" + NL + "                    mdmTransaction_";
  protected final String TEXT_165 = ".setSessionId(sessionID_";
  protected final String TEXT_166 = ");" + NL + "                }else{";
  protected final String TEXT_167 = NL + "                    mdmTransaction_";
  protected final String TEXT_168 = " = com.talend.mdm.transaction.client.MDMTransactionClient.newTransaction(turl_";
  protected final String TEXT_169 = ",username_";
  protected final String TEXT_170 = ",password_";
  protected final String TEXT_171 = ");" + NL + "                }" + NL + "                java.util.List<org.apache.cxf.headers.Header> soapHeaders_";
  protected final String TEXT_172 = " = new java.util.ArrayList<org.apache.cxf.headers.Header>();" + NL + "                javax.xml.namespace.QName qName_";
  protected final String TEXT_173 = " = new javax.xml.namespace.QName(\"http://www.talend.com/mdm\", \"transaction-id\");" + NL + "                org.apache.cxf.databinding.DataBinding dataBinding_";
  protected final String TEXT_174 = " = new org.apache.cxf.jaxb.JAXBDataBinding(String.class);" + NL + "                soapHeaders_";
  protected final String TEXT_175 = ".add(new org.apache.cxf.headers.Header(qName_";
  protected final String TEXT_176 = ", mdmTransaction_";
  protected final String TEXT_177 = ".getId(), dataBinding_";
  protected final String TEXT_178 = "));" + NL + "                context_";
  protected final String TEXT_179 = ".put(org.apache.cxf.headers.Header.HEADER_LIST, soapHeaders_";
  protected final String TEXT_180 = ");" + NL + "" + NL + "                java.util.Map<String, java.util.List<String>> httpHeaders_";
  protected final String TEXT_181 = " = new java.util.HashMap<String, java.util.List<String>>();" + NL + "                String cookie_";
  protected final String TEXT_182 = " = com.talend.mdm.transaction.client.MDMTransaction.getStickySession() + \"=\" + mdmTransaction_";
  protected final String TEXT_183 = ".getSessionId();" + NL + "                httpHeaders_";
  protected final String TEXT_184 = ".put(\"Cookie\", java.util.Arrays.asList(cookie_";
  protected final String TEXT_185 = "));" + NL + "                context_";
  protected final String TEXT_186 = ".put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, httpHeaders_";
  protected final String TEXT_187 = ");" + NL + "" + NL + "                globalMap.put(transKey_";
  protected final String TEXT_188 = ", mdmTransaction_";
  protected final String TEXT_189 = ");";
  protected final String TEXT_190 = NL + "            }" + NL + "        }" + NL + "        service_";
  protected final String TEXT_191 = ".ping(new org.talend.mdm.webservice.WSPing());";
  protected final String TEXT_192 = NL + "        globalMap.put(connKey_";
  protected final String TEXT_193 = ", service_";
  protected final String TEXT_194 = ");" + NL + "    }";
  protected final String TEXT_195 = NL + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_196 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_197 = " + \"";
  protected final String TEXT_198 = "\");" + NL + "org.talend.mdm.webservice.WSDataModelPK dataModel_";
  protected final String TEXT_199 = " = new org.talend.mdm.webservice.WSDataModelPK(";
  protected final String TEXT_200 = ");" + NL + "" + NL + "String input_";
  protected final String TEXT_201 = ";" + NL + "" + NL + "java.util.List<org.talend.mdm.webservice.WSItemPK> wspks_";
  protected final String TEXT_202 = ";" + NL + "org.talend.mdm.webservice.WSItemPK wspk_";
  protected final String TEXT_203 = ";" + NL;
  protected final String TEXT_204 = NL + "    java.util.Queue<String> queue_";
  protected final String TEXT_205 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();";
  protected final String TEXT_206 = NL + "        java.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_207 = " = java.util.Collections.synchronizedList(new java.util.ArrayList<java.util.Map<String,String>>());" + NL + "        int flowNum_";
  protected final String TEXT_208 = " = 0;";
  protected final String TEXT_209 = NL + "    class ThreadXMLField_";
  protected final String TEXT_210 = " extends Thread {" + NL + "        java.util.Queue<String> queue;" + NL + "        java.util.List<java.util.Map<String,String>> flows;" + NL + "        java.lang.Exception lastException;" + NL + "        String currentComponent;" + NL + "" + NL + "        ThreadXMLField_";
  protected final String TEXT_211 = "(java.util.Queue q) {" + NL + "            this.queue = q;" + NL + "            globalMap.put(\"queue_";
  protected final String TEXT_212 = "\", queue);" + NL + "            lastException = null;" + NL + "        }" + NL + "" + NL + "        ThreadXMLField_";
  protected final String TEXT_213 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "            this.queue = q;" + NL + "            this.flows = l;" + NL + "            lastException = null;" + NL + "            globalMap.put(\"queue_";
  protected final String TEXT_214 = "\", queue);" + NL + "            globalMap.put(\"flows_";
  protected final String TEXT_215 = "\", flows);" + NL + "        }" + NL + "" + NL + "        public java.lang.Exception getLastException() {" + NL + "            return this.lastException;" + NL + "        }" + NL + "        public String getCurrentComponent() {" + NL + "            return this.currentComponent;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void run() {" + NL + "            try {";
  protected final String TEXT_216 = NL + "                ";
  protected final String TEXT_217 = "Process(globalMap);" + NL + "            } catch (TalendException te) {" + NL + "                this.lastException = te.getException();" + NL + "                this.currentComponent = te.getCurrentComponent();" + NL + "                globalMap.put(\"";
  protected final String TEXT_218 = "_FINISH\" + (this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_219 = NL + "        ThreadXMLField_";
  protected final String TEXT_220 = " txf_";
  protected final String TEXT_221 = " = new ThreadXMLField_";
  protected final String TEXT_222 = "(queue_";
  protected final String TEXT_223 = ", xmlFlowList_";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "        ThreadXMLField_";
  protected final String TEXT_226 = " txf_";
  protected final String TEXT_227 = " = new ThreadXMLField_";
  protected final String TEXT_228 = "(queue_";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = NL + "    txf_";
  protected final String TEXT_231 = ".start();";
  protected final String TEXT_232 = NL + "        java.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_233 = " = (java.util.List<java.util.Map<String,String>>)globalMap.get(\"flows_";
  protected final String TEXT_234 = "\");" + NL + "        int flowNum_";
  protected final String TEXT_235 = " = 0;";
  protected final String TEXT_236 = NL + "    java.util.Queue<String> queue_";
  protected final String TEXT_237 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_238 = "\");";
  protected final String TEXT_239 = NL + "    String readFinishMarkWithPipeId_";
  protected final String TEXT_240 = " = \"";
  protected final String TEXT_241 = "_FINISH\"+(queue_";
  protected final String TEXT_242 = "==null?\"\":queue_";
  protected final String TEXT_243 = ".hashCode());" + NL + "    while(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_244 = ") || !queue_";
  protected final String TEXT_245 = ".isEmpty()) {" + NL + "        if (!queue_";
  protected final String TEXT_246 = ".isEmpty()) {";
  protected final String TEXT_247 = NL;

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
String virtualcid = cid;
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

boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    if(!usePartialUpdate){
    if(addTaskID){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    }
    if(isMassInsert){
        if(!isStaging && withReport){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
        }else{
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
        }
        if(addTaskID){
    
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
        }
    }
}
    stringBuffer.append(TEXT_55);
    if(!useExistingConn){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
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
    stringBuffer.append(username );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
     String passwordFieldName = "__PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    } else {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    }else if(isProvisioning){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_95);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
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
    }else{
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(trans);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_128);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
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
     logUtil.debug("\"Got service successfully with key=\" + connKey_" + cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
     logUtil.debug("\"Attempt to get a remote transaction from url: \" + murl_" + cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
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
     logUtil.debug("\"Got transaction successfully with key=\" + transKey_" + cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    //For TDI-26109
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(dataModel );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null;
if(startNode != null){
    startNodeCid = startNode.getUniqueName();
}
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    
    if(storeFlow){
    
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    
    }
    
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_218);
    if(storeFlow){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    }else{
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    
}else{
    if(storeFlow){
    
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    
    }
    
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_238);
    
}

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(TEXT_247);
    return stringBuffer.toString();
  }
}
