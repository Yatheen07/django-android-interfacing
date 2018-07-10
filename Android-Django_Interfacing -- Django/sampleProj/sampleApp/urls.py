# -*- coding: utf-8 -*-
"""
Created on Tue Jul 10 21:46:10 2018

@author: kmy07
"""

from django.contrib import admin
from django.urls import path
from sampleApp import views
from django.conf.urls import url
from django.conf.urls import include

urlpatterns = [
    url(r'^register_user/(?P<string>[\w\-]+)/$',views.register_user)
]