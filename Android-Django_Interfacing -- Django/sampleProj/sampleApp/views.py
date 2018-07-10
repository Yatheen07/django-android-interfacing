from django.shortcuts import render
from django.http import JsonResponse

# Create your views here.
def register_user(request,string):
    if request.method == "POST":
        string_input = string.split("-")
        
        userName = string_input[0]
        userNumber = string_input[1]
        userAge = string_input[2]
        
        result = {"Name":userName,"Number":userNumber,"Age":userAge}
        print(result)
        
        return JsonResponse({"Result":result},status=201)
        
        
