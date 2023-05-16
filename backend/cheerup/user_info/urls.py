from django.urls import path
from . import views

urlpatterns = [
    path("", views.UserInfoRegisterView.as_view()),
]