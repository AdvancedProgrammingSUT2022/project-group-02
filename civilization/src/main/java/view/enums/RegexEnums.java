package view.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegexEnums {
    //regex for user login
    LOGIN1("^\\s*user\\s+login\\s+--username\\s+(?<username>[\\s\\S]+)\\s+--password\\s+(?<password>[\\s\\S]+)\\s*$"),
    LOGIN2("^\\s*user\\s+login\\s+-u\\s+(?<username>[\\s\\S]+)\\s+-p\\s+(?<password>[\\s\\S]+)\\s*$"),
    //handle abbreviation input and different order of input
    LOGIN3("^\\s*user\\s+login\\s+--password\\s+(?<password>[\\s\\S]+)\\s+--username\\s+(?<username>[\\s\\S]+)\\s*$"),
    LOGIN4("^\\s*user\\s+login\\s+-p\\s+(?<password>[\\s\\S]+)\\s+-u\\s+(?<username>[\\s\\S]+)\\s*$"),
    //menu navigation
    CHANGE_MENU("^\\s*menu\\s+enter\\s+(?<menu>[\\s\\S]+)\\s*$"),
    //regex for user register + handling abbreviation input + different order of input
    REGISTER1("^\\s*user\\s+create\\s+--username\\s+(?<username>[\\s\\S]+)\\s+--nickname\\s+(?<nickname>[\\s\\S]+)\\s+--password\\s+(?<password>[\\s\\S]+)\\s*$"),
    REGISTER2("^\\s*user\\s+create\\s+-u\\s+(?<username>[\\s\\S]+)\\s+-n\\s+(?<nickname>[\\s\\S]+)\\s+-p\\s+(?<password>[\\s\\S]+)\\s*$"),

    REGISTER3("^\\s*user\\s+create\\s+--username\\s+(?<username>[\\s\\S]+)\\s+--password\\s+(?<password>[\\s\\S]+)\\s+--nickname\\s+(?<nickname>[\\s\\S]+)\\s*$"),
    REGISTER4("^\\s*user\\s+create\\s+-u\\s+(?<username>[\\s\\S]+)\\s+-p\\s+(?<password>[\\s\\S]+)\\s+-n\\s+(?<nickname>[\\s\\S]+)\\s*$"),

    REGISTER5("^\\s*user\\s+create\\s+--password\\s+(?<password>[\\s\\S]+)\\s+--nickname\\s+(?<nickname>[\\s\\S]+)\\s+--username\\s+(?<username>[\\s\\S]+)\\s*$"),
    REGISTER6("^\\s*user\\s+create\\s+-p\\s+(?<password>[\\s\\S]+)\\s+-n\\s+(?<nickname>[\\s\\S]+)\\s+-u\\s+(?<username>[\\s\\S]+)\\s*$"),

    REGISTER7("^\\s*user\\s+create\\s+--password\\s+(?<password>[\\s\\S]+)\\s+--username\\s+(?<username>[\\s\\S]+)\\s+--nickname\\s+(?<nickname>[\\s\\S]+)\\s*$"),
    REGISTER8("^\\s*user\\s+create\\s+-p\\s+(?<password>[\\s\\S]+)\\s+-u\\s+(?<username>[\\s\\S]+)\\s+-n\\s+(?<nickname>[\\s\\S]+)\\s*$"),

    REGISTER9("^\\s*user\\s+create\\s+--nickname\\s+(?<nickname>[\\s\\S]+)\\s+--username\\s+(?<username>[\\s\\S]+)\\s+--password\\s+(?<password>[\\s\\S]+)\\s*$"),
    REGISTER10("^\\s*user\\s+create\\s+-n\\s+(?<nickname>[\\s\\S]+)\\s+-u\\s+(?<username>[\\s\\S]+)\\s+-p\\s+(?<password>[\\s\\S]+)\\s*$"),

    REGISTER11("^\\s*user\\s+create\\s+--nickname\\s+(?<nickname>[\\s\\S]+)\\s+--password\\s+(?<password>[\\s\\S]+)\\s+--username\\s+(?<username>[\\s\\S]+)\\s*$"),
    REGISTER12("^\\s*user\\s+create\\s+-n\\s+(?<nickname>[\\s\\S]+)\\s+-p\\s+(?<password>[\\s\\S]+)\\s+-u\\s+(?<username>[\\s\\S]+)\\s*$"),
    //change nickname + abbreviation
    CHANGE_NICKNAME1("^\\s*profile\\s+change\\s+--nickname\\s+(?<nickname>[\\s\\S]+)\\s*$"),
    CHANGE_NICKNAME2("^\\s*profile\\s+change\\s+-n\\s+(?<nickname>[\\s\\S]+)\\s*$"),
    //change password + abbreviation
    CHANGE_PASSWORD1("^\\s*profile\\s+change\\s+--password\\s+--current\\s+(?<currentPassword>[\\s\\S]+)\\s+--new\\s+(?<newPassword>[\\s\\S]+)\\s*$"),
    CHANGE_PASSWORD2("^\\s*profile\\s+change\\s+--password\\s+--new\\s+(?<newPassword>[\\s\\S]+)\\s+--current\\s+(?<currentPassword>[\\s\\S]+)\\s*$"),
    CHANGE_PASSWORD3("^\\s*profile\\s+change\\s+-p\\s+-c\\s+(?<currentPassword>[\\s\\S]+)\\s+-n\\s+(?<newPassword>[\\s\\S]+)\\s*$"),
    CHANGE_PASSWORD4("^\\s*profile\\s+change\\s+-p\\s+-n\\s+(?<newPassword>[\\s\\S]+)\\s+-c\\s+(?<currentPassword>[\\s\\S]+)\\s*$"),
    //increase turn + abbreviation
    INCREASE_TURN1("^\\s*increase\\s+--turn\\s+(?<amount>\\-?\\d+)\\s*$"),
    INCREASE_TURN2("^\\s*increase\\s+-t\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase gold + abbreviation
    INCREASE_GOLD1("^\\s*increase\\s+--gold\\s+(?<amount>\\-?\\d+)\\s*$"),
    INCREASE_GOLD2("^\\s*increase\\s+-g\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase happiness
    INCREASE_HAPPINESS("^\\s*increase\\s+--happiness\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase food
    INCREASE_FOOD("^\\s*increase\\s+--food\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase culture
    INCREASE_CULTURE("^\\s*increase\\s+--culture\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase faith
    INCREASE_FAITH("^\\s*increase\\s+--faith\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase citizen
    INCREASE_CAPITAL_CITIZENS("^\\s*increase\\s+--citizens\\s+(?<amount>\\-?\\d+)\\s*$"),
    //decrease research turn left
    DECREASE_RESEARCH_TURN_LEFT("^\\s*increase\\s+--research\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase science
    INCREASE_SCIENCE("^\\s*increase\\s+--science\\s+(?<amount>\\-?\\d+)\\s*$"),
    //increase city defence
    INCREASE_CAPITAL_DEFENCE("^\\s*increase\\s+--defence\\s+(?<amount>\\-?\\d+)\\s*$"),
    //add a research
    ADD_RESEARCH1("^\\s*add\\s+--research\\s+(?<index>\\d+)\\s*$"),
    ADD_RESEARCH2("^\\s*add\\s+-r\\s+(?<index>\\d+)\\s*$"),
    // add a product
    ADD_PRODUCT1("^\\s*add\\s+--product\\s+(?<index>\\d+)\\s*$"),
    ADD_PRODUCT2("^\\s*add\\s+-p\\s+(?<index>\\d+)\\s*$"),
    // add a improvement
    ADD_IMPROVEMENT1("^\\s*add\\s+--improvement\\s+(?<index>\\d+)\\s*$"),
    ADD_IMPROVEMENT2("^\\s*add\\s+-i\\s+(?<index>\\d+)\\s*$"),
    //selecting a tile
    SELECT_TILE1("^\\s*select\\s+tile\\s+-x\\s+(?<x>\\-?\\d+)\\s+-y\\s+(?<y>\\-?\\d+)\\s*$"),
    SELECT_TILE2("^\\s*select\\s+tile\\s+-y\\s+(?<y>\\-?\\d+)\\s+-x\\s+(?<x>\\-?\\d+)\\s*$"),
    //move unit
    MOVE1("^\\s*move\\s+unit\\s+to\\s+-x\\s+(?<x>\\-?\\d+)\\s+-y\\s+(?<y>\\-?\\d+)\\s*$"),
    MOVE2("^\\s*move\\s+unit\\s+to\\s+-y\\s+(?<y>\\-?\\d+)\\s+-x\\s+(?<x>\\-?\\d+)\\s*$"),
    //attack city
    ATTACK_CITY1("^\\s*attack\\s+city\\s+-x\\s+(?<x>\\d+)\\s+-y\\s+(?<y>\\d+)\\s*$"),
    ATTACK_CITY2("^\\s*attack\\s+city\\s+-y\\s+(?<y>\\d+)\\s+-x\\s+(?<x>\\d+)\\s*$"),
    //buy tile
    BUY_TILE1("^\\s*buy\\s+--tile\\s+(?<index>\\d+)\\s*$"),
    BUY_TILE2("^\\s*buy\\s+-t\\s+(?<index>\\d+)\\s*$"),
    //place city
    CITY1("^\\s*place\\s+city\\s+--name\\s+(?<city>[\\s\\S]+)\\s*$"),
    CITY2("^\\s*place\\s+city\\s+-n\\s+(?<city>[\\s\\S]+)\\s*$");


    private String regex;

    RegexEnums(String regex) {
        this.regex = regex;
    }

    //input matches the regex or not?
    public static Matcher getMatcher(String input, RegexEnums regexEnums) {
        Matcher matcher = Pattern.compile(regexEnums.regex).matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }
}
