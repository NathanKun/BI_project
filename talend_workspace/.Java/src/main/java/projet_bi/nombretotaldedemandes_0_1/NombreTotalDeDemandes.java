// ============================================================================
//
// Copyright (c) 2006-2015, Talend Inc.
//
// This source code has been automatically generated by_Talend Open Studio for Data Integration
// / Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package projet_bi.nombretotaldedemandes_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")
/**
 * Job: NombreTotalDeDemandes Purpose: Nombre total de demandes pour partenaires<br>
 * Description:  <br>
 * @author user@talend.com
 * @version 6.2.1.20160704_1411
 * @status 
 */
public class NombreTotalDeDemandes implements TalendJob {

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset
			.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends java.util.Properties {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

	}

	private ContextProperties context = new ContextProperties();

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "NombreTotalDeDemandes";
	private final String projectName = "PROJET_BI";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	public void setDataSources(
			java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources
				.entrySet()) {
			talendDataSources.put(
					dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry
							.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(
			new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent,
				final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null
						&& currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE",
							getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE",
						getExceptionCauseMessage(e));
				System.err
						.println("Exception in component " + currentComponent);
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					NombreTotalDeDemandes.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(NombreTotalDeDemandes.this, new Object[] {
									e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tOracleInput_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tOracleInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tOracleInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tOracleInput_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row1Struct implements
			routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_PROJET_BI_NombreTotalDeDemandes = new byte[0];
		static byte[] commonByteArray_PROJET_BI_NombreTotalDeDemandes = new byte[0];

		public String Partenaire_Nom;

		public String getPartenaire_Nom() {
			return this.Partenaire_Nom;
		}

		public BigDecimal Nombre_total_de_demande;

		public BigDecimal getNombre_total_de_demande() {
			return this.Nombre_total_de_demande;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJET_BI_NombreTotalDeDemandes.length) {
					if (length < 1024
							&& commonByteArray_PROJET_BI_NombreTotalDeDemandes.length == 0) {
						commonByteArray_PROJET_BI_NombreTotalDeDemandes = new byte[1024];
					} else {
						commonByteArray_PROJET_BI_NombreTotalDeDemandes = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJET_BI_NombreTotalDeDemandes,
						0, length);
				strReturn = new String(
						commonByteArray_PROJET_BI_NombreTotalDeDemandes, 0,
						length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJET_BI_NombreTotalDeDemandes) {

				try {

					int length = 0;

					this.Partenaire_Nom = readString(dis);

					this.Nombre_total_de_demande = (BigDecimal) dis
							.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Partenaire_Nom, dos);

				// BigDecimal

				dos.writeObject(this.Nombre_total_de_demande);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Partenaire_Nom=" + Partenaire_Nom);
			sb.append(",Nombre_total_de_demande="
					+ String.valueOf(Nombre_total_de_demande));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tOracleInput_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tOracleInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {

			String currentMethodName = new java.lang.Exception()
					.getStackTrace()[0].getMethodName();
			boolean resumeIt = currentMethodName.equals(resumeEntryMethodName);
			if (resumeEntryMethodName == null || resumeIt || globalResumeTicket) {// start
																					// the
																					// resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);

					}
				}

				int tos_count_tLogRow_1 = 0;

				// /////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
				java.io.PrintStream consoleOut_tLogRow_1 = null;

				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
				// /////////////////////

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tOracleInput_1 begin ] start
				 */

				ok_Hash.put("tOracleInput_1", false);
				start_Hash.put("tOracleInput_1", System.currentTimeMillis());

				currentComponent = "tOracleInput_1";

				int tos_count_tOracleInput_1 = 0;

				int nb_line_tOracleInput_1 = 0;
				java.sql.Connection conn_tOracleInput_1 = null;
				String driverClass_tOracleInput_1 = "oracle.jdbc.OracleDriver";
				java.lang.Class.forName(driverClass_tOracleInput_1);

				String url_tOracleInput_1 = null;
				url_tOracleInput_1 = "jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host="
						+ "srvlaboinfo"
						+ ")(port="
						+ "1521"
						+ "))(connect_data=(service_name="
						+ "orcl.intranet.int" + ")))";

				String dbUser_tOracleInput_1 = "BI_2";

				final String decryptedPassword_tOracleInput_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("7acac362d4dfb4fc");

				String dbPwd_tOracleInput_1 = decryptedPassword_tOracleInput_1;

				conn_tOracleInput_1 = java.sql.DriverManager.getConnection(
						url_tOracleInput_1, dbUser_tOracleInput_1,
						dbPwd_tOracleInput_1);
				java.sql.Statement stmtGetTZ_tOracleInput_1 = conn_tOracleInput_1
						.createStatement();
				java.sql.ResultSet rsGetTZ_tOracleInput_1 = stmtGetTZ_tOracleInput_1
						.executeQuery("select sessiontimezone from dual");
				String sessionTimezone_tOracleInput_1 = java.util.TimeZone
						.getDefault().getID();
				while (rsGetTZ_tOracleInput_1.next()) {
					sessionTimezone_tOracleInput_1 = rsGetTZ_tOracleInput_1
							.getString(1);
				}
				((oracle.jdbc.OracleConnection) conn_tOracleInput_1)
						.setSessionTimeZone(sessionTimezone_tOracleInput_1);

				java.sql.Statement stmt_tOracleInput_1 = conn_tOracleInput_1
						.createStatement();

				String dbquery_tOracleInput_1 = "SELECT \n  BI_2.PARTENAIRE_PTN.PTN_NOM AS \"Partenaire Nom\", \n  SUM(BI_2.FAIT_PARTENAIRE.NBRE_DEMANDE) AS \"Nombre total de demande\"\n  FROM BI_2.FAIT_PARTENAIRE\n  INNER JOIN BI_2.PARTENAIRE_PTN \n    ON BI_2.PARTENAIRE_PTN.PTN_ID = BI_2.FAIT_PARTENAIRE.ACT_ID\nGROUP BY  BI_2.PARTENAIRE_PTN.PTN_NOM";

				globalMap.put("tOracleInput_1_QUERY", dbquery_tOracleInput_1);

				java.sql.ResultSet rs_tOracleInput_1 = null;
				try {
					rs_tOracleInput_1 = stmt_tOracleInput_1
							.executeQuery(dbquery_tOracleInput_1);
					java.sql.ResultSetMetaData rsmd_tOracleInput_1 = rs_tOracleInput_1
							.getMetaData();
					int colQtyInRs_tOracleInput_1 = rsmd_tOracleInput_1
							.getColumnCount();

					String tmpContent_tOracleInput_1 = null;

					while (rs_tOracleInput_1.next()) {
						nb_line_tOracleInput_1++;

						if (colQtyInRs_tOracleInput_1 < 1) {
							row1.Partenaire_Nom = null;
						} else {

							tmpContent_tOracleInput_1 = rs_tOracleInput_1
									.getString(1);
							if (tmpContent_tOracleInput_1 != null) {
								row1.Partenaire_Nom = tmpContent_tOracleInput_1;
							} else {
								row1.Partenaire_Nom = null;
							}
						}
						if (colQtyInRs_tOracleInput_1 < 2) {
							row1.Nombre_total_de_demande = null;
						} else {

							if (rs_tOracleInput_1.getObject(2) != null) {
								row1.Nombre_total_de_demande = rs_tOracleInput_1
										.getBigDecimal(2);
							} else {

								row1.Nombre_total_de_demande = null;
							}
						}

						/**
						 * [tOracleInput_1 begin ] stop
						 */

						/**
						 * [tOracleInput_1 main ] start
						 */

						currentComponent = "tOracleInput_1";

						tos_count_tOracleInput_1++;

						/**
						 * [tOracleInput_1 main ] stop
						 */

						/**
						 * [tLogRow_1 main ] start
						 */

						currentComponent = "tLogRow_1";

						// row1
						// row1

						if (execStat) {
							runStat.updateStatOnConnection("row1" + iterateId,
									1, 1);
						}

						// /////////////////////

						strBuffer_tLogRow_1 = new StringBuilder();

						if (row1.Partenaire_Nom != null) { //

							strBuffer_tLogRow_1.append(String
									.valueOf(row1.Partenaire_Nom));

						} //

						strBuffer_tLogRow_1.append("|");

						if (row1.Nombre_total_de_demande != null) { //

							strBuffer_tLogRow_1
									.append(row1.Nombre_total_de_demande
											.setScale(
													0,
													java.math.RoundingMode.HALF_UP)
											.toPlainString());

						} //

						if (globalMap.get("tLogRow_CONSOLE") != null) {
							consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap
									.get("tLogRow_CONSOLE");
						} else {
							consoleOut_tLogRow_1 = new java.io.PrintStream(
									new java.io.BufferedOutputStream(System.out));
							globalMap.put("tLogRow_CONSOLE",
									consoleOut_tLogRow_1);
						}
						consoleOut_tLogRow_1.println(strBuffer_tLogRow_1
								.toString());
						consoleOut_tLogRow_1.flush();
						nb_line_tLogRow_1++;
						// ////

						// ////

						// /////////////////////

						tos_count_tLogRow_1++;

						/**
						 * [tLogRow_1 main ] stop
						 */

						/**
						 * [tOracleInput_1 end ] start
						 */

						currentComponent = "tOracleInput_1";

					}
				} finally {
					stmt_tOracleInput_1.close();

					if (conn_tOracleInput_1 != null
							&& !conn_tOracleInput_1.isClosed()) {

						conn_tOracleInput_1.close();

					}

				}

				globalMap.put("tOracleInput_1_NB_LINE", nb_line_tOracleInput_1);

				ok_Hash.put("tOracleInput_1", true);
				end_Hash.put("tOracleInput_1", System.currentTimeMillis());

				/**
				 * [tOracleInput_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

				// ////
				// ////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row1" + iterateId, 2, 0);
					}
				}

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

			}// end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tOracleInput_1 finally ] start
				 */

				currentComponent = "tOracleInput_1";

				/**
				 * [tOracleInput_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tOracleInput_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private java.util.Properties context_param = new java.util.Properties();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final NombreTotalDeDemandes NombreTotalDeDemandesClass = new NombreTotalDeDemandes();

		int exitCode = NombreTotalDeDemandesClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket
				// can't open
				System.err.println("The statistics socket port " + portStats
						+ " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}

		try {
			// call job/subjob with an existing context, like:
			// --context=production. if without this parameter, there will use
			// the default context instead.
			java.io.InputStream inContext = NombreTotalDeDemandes.class
					.getClassLoader().getResourceAsStream(
							"projet_bi/nombretotaldedemandes_0_1/contexts/"
									+ contextStr + ".properties");
			if (isDefaultContext && inContext == null) {

			} else {
				if (inContext != null) {
					// defaultProps is in order to keep the original context
					// value
					defaultProps.load(inContext);
					inContext.close();
					context = new ContextProperties(defaultProps);
				} else {
					// print info and job continue to run, for case:
					// context_param is not empty.
					System.err.println("Could not find the context "
							+ contextStr);
				}
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
			}
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName,
				parent_part_launcher, Thread.currentThread().getId() + "", "",
				"", "", "",
				resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tOracleInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tOracleInput_1) {
			globalMap.put("tOracleInput_1_SUBPROCESS_STATE", -1);

			e_tOracleInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		if (false) {
			System.out
					.println((endUsedMemory - startUsedMemory)
							+ " bytes memory increase when running : NombreTotalDeDemandes");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher,
				Thread.currentThread().getId() + "", "", "" + returnCode, "",
				"", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		}

	}

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" },
			{ "\\'", "\'" }, { "\\r", "\r" }, { "\\f", "\f" }, { "\\b", "\b" },
			{ "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex,
							index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left
			// into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 32218 characters generated by Talend Open Studio for Data Integration on the
 * 1 février 2018 14:57:44 CET
 ************************************************************************************************/