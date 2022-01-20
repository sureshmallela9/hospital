/*
 * package com.hospital.config;
 * 
 * import static java.util.Arrays.asList;
 * 
 * import java.util.HashSet; import java.util.Set; import
 * java.util.stream.Collectors; import java.util.stream.Stream; import
 * lombok.Getter;
 * 
 * public final class ServiceHeader {
 * 
 * public static final String API_KEY_STRING = "apikey"; public static final
 * String BUSINESS_DIVISION_CODE_STRING = "businessDivisionCode"; public static
 * final String BUSINESS_PROCESS_INSTANCE_ID_STRING =
 * "businessProcessInstanceId"; public static final String
 * BUSINESS_TRANSACTION_ID_STRING = "businessTransactionId"; public static final
 * String CUSTOMER_ACCOUNT_NUMBER_STRING = "customerAccountNumber"; public
 * static final String GROUP_ID_STRING = "groupId"; public static final String
 * IN_TRANSACTION_STRING = "inTransaction"; public static final String
 * LOCALE_STRING = "locale"; public static final String
 * REQUEST_CORRELATION_ID_STRING = "requestCorrelationId"; public static final
 * String ROLE_STRING = "role"; public static final String SOURCE_SYSTEM_STRING
 * = "sourceSystem"; public static final String TENANT_ID_STRING = "tenantId";
 * public static final String TIME_ZONE_STRING = "timeZone"; public static final
 * String TRANSACTION_ID_STRING = "transactionId"; public static final String
 * USER_ID_STRING = "userId";
 * 
 * @Getter private static final Set<String> requiredNames = new
 * HashSet<>(asList( REQUEST_CORRELATION_ID_STRING, SOURCE_SYSTEM_STRING ));
 * 
 * @Getter private static final Set<String> optionalNames = new
 * HashSet<>(asList( API_KEY_STRING, BUSINESS_DIVISION_CODE_STRING,
 * BUSINESS_PROCESS_INSTANCE_ID_STRING, BUSINESS_TRANSACTION_ID_STRING,
 * CUSTOMER_ACCOUNT_NUMBER_STRING, LOCALE_STRING, GROUP_ID_STRING,
 * IN_TRANSACTION_STRING, ROLE_STRING, TENANT_ID_STRING, TIME_ZONE_STRING,
 * TRANSACTION_ID_STRING, USER_ID_STRING ));
 * 
 * @Getter private static final Set<String> allNames =
 * Stream.concat(requiredNames.stream(), optionalNames.stream())
 * .collect(Collectors.toSet());
 * 
 * private ServiceHeader() { throw new IllegalStateException("Utility class"); }
 * }
 */