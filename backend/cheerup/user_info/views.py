from rest_framework.response import Response
from rest_framework import (
    generics, 
    mixins, 
    status,
)
from .models import UserInfo
from .serializers import (

    UserInfoSerializer,
)

class UserInfoRegisterView(
    mixins.CreateModelMixin, 
    generics.GenericAPIView,
):
    serializer_class = UserInfoSerializer

    def post(self, request, *args, **kwargs):
        return self.create(request, args, kwargs)