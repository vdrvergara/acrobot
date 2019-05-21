package com.redhat.helpers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class JsonNodeHelper {
    private static ObjectMapper mapper = new ObjectMapper();
    private static JsonFactory factory = mapper.getFactory();
    private static String ACRONYM = "FOO1";
    public static String EXPLANATION = "BAR1";
    public static String EXPLANATION_UPDATE = "BAR2";
    private static String SAVE_ACRONYM = "!  " + ACRONYM + "  =  " + EXPLANATION;
    private static String UPDATE_ACRONYM = "! " + ACRONYM + " = " + EXPLANATION_UPDATE;
    private static String INCORRECT_ACRONYM = "ACRONYM";
    private static String INCORRECT_ACRONYM_SAVE = "!" + INCORRECT_ACRONYM + "  ";
    private static String INCORRECT_ACRONYM_SAVE_WITH_EQUALS = "! " + INCORRECT_ACRONYM + " =   ";

    public static JsonNode getJsonNodeWithoutMessageArgumentText() {
        try {
            JsonParser parser = factory.createParser(getJsonStringNoArgumentText());
            return mapper.readTree(parser);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonNode getHelpRequest() {
        return alterArgumentText("help");
    }

    public static JsonNode getAddAcronymRequest() {
        return alterArgumentText(SAVE_ACRONYM);
    }

    public static JsonNode getAcronymLowercase() {
        return alterArgumentText(ACRONYM.toLowerCase());
    }

    public static JsonNode getAcronymUppercase() {
        return alterArgumentText(ACRONYM);
    }

    public static JsonNode getUpdateAcronym() {
        return alterArgumentText(UPDATE_ACRONYM);
    }

    public static JsonNode getIncorrectAcronymSave() {
        return alterArgumentText(INCORRECT_ACRONYM_SAVE);
    }

    public static JsonNode getIncorrectAcronymSaveWithEquals() {
        return alterArgumentText(INCORRECT_ACRONYM_SAVE_WITH_EQUALS);
    }

    public static JsonNode getIncorrectAcronym() {
        return alterArgumentText(INCORRECT_ACRONYM);
    }

    private static ObjectNode alterArgumentText(String argumentTextString) {
        JsonNode node = JsonNodeHelper.getJsonNodeWithoutMessageArgumentText();
        ObjectNode nodeHelpText = ((ObjectNode) node);
        ObjectNode message = (ObjectNode) nodeHelpText.get("message");
        message.put("argumentText", argumentTextString);
        nodeHelpText.set("message", message);
        return nodeHelpText;
    }

    private static String getJsonStringNoArgumentText() {
        return "{\n" +
                "    \"type\": \"MESSAGE\",\n" +
                "    \"eventTime\": \"2019-05-16T06:58:32.030735Z\",\n" +
                "    \"message\": {\n" +
                "        \"name\": \"spaces/a\",\n" +
                "        \"sender\": {\n" +
                "            \"name\": \"users/test\",\n" +
                "            \"displayName\": \"John Doe\",\n" +
                "            \"avatarUrl\": \"https://lh3.googleusercontent.com/a-/handsomeFella.jpg\",\n" +
                "            \"email\": \"jdoe@example.com\",\n" +
                "            \"type\": \"HUMAN\"\n" +
                "        },\n" +
                "        \"createTime\": \"2019-05-16T06:58:32.030735Z\",\n" +
                "        \"text\": \"@Acrobot\",\n" +
                "        \"annotations\": [\n" +
                "            {\n" +
                "                \"type\": \"USER_MENTION\",\n" +
                "                \"startIndex\": 0,\n" +
                "                \"length\": 13,\n" +
                "                \"userMention\": {\n" +
                "                    \"user\": {\n" +
                "                        \"name\": \"users/bb\",\n" +
                "                        \"displayName\": \"Acrobot\",\n" +
                "                        \"avatarUrl\": \"https://lh6.googleusercontent.com/proxy/botAwesomeness.jpeg\",\n" +
                "                        \"type\": \"BOT\"\n" +
                "                    },\n" +
                "                    \"type\": \"ADD\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"thread\": {\n" +
                "            \"name\": \"spaces/aaa/threads/bbb\",\n" +
                "            \"retentionSettings\": {\n" +
                "                \"state\": \"PERMANENT\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"space\": {\n" +
                "            \"name\": \"spaces/aaa\",\n" +
                "            \"type\": \"ROOM\",\n" +
                "            \"displayName\": \"Red Hat Goodness\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"user\": {\n" +
                "        \"name\": \"users/test\",\n" +
                "        \"displayName\": \"John Doe\",\n" +
                "        \"avatarUrl\": \"https://lh3.googleusercontent.com/a-/handsomeFella.jpg\",\n" +
                "        \"email\": \"jdoe@example.com\",\n" +
                "        \"type\": \"HUMAN\"\n" +
                "    },\n" +
                "    \"space\": {\n" +
                "        \"name\": \"spaces/AAAA9H9KKTo\",\n" +
                "        \"type\": \"ROOM\",\n" +
                "        \"displayName\": \"Red Hat Goodness\"\n" +
                "    }\n" +
                "}\n";
    }
}
