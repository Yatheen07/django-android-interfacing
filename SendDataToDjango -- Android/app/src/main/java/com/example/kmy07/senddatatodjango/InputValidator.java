package com.example.kmy07.senddatatodjango;

public class InputValidator {
    private String userName,userNumber,userAge;

    public InputValidator(String userName,String userNumber,String userAge){
        this.userAge = userAge;
        this.userName = userName;
        this.userNumber = userNumber;
    }

    private static boolean validateName(String userName){
        return userName.matches("[a-zA-Z]+");
    }

    private static boolean validateNumber(String userNumber){
        return (userNumber.length() == 10) ? true : false;
    }

    private static boolean validateAge(String userAge){
        int age = Integer.parseInt(userAge);
        return (age >=0 && age<=125) ? true : false;
    }

    public String validateInput(){
        StringBuffer result = new StringBuffer();
        if(userName.isEmpty() || userNumber.isEmpty() || userAge.isEmpty()){
            result.append("Empty Inputs! Enter All the Fields!");
        }
        else{
            if(!validateName(userName)) result.append("Enter Name Properly\n");
            if(!validateAge(userAge))   result.append("Enter Age Properly\n");
            if(!validateNumber(userNumber)) result.append("Enter Number Properly\n");
        }
        return result.toString();
    }
}
