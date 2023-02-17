class Solution {
    public String solution(String phone_number) {
        return phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*") + phone_number.substring(phone_number.length() - 4);
    }
}
