from rest_framework import serializers
from .models import UserInfo
# from django.contrib.auth.hashers import make_password

class UserInfoSerializer(serializers.ModelSerializer):
    # def validate_password(self, value):
    #     # regix
    #     if len(value) < 8:
    #         raise serializers.ValidationError("Too short password")

    #     return make_password(value)

    class Meta:
        model = UserInfo
        fields = ('user_id', 'name', 'tel')
        extra_kwargs = {
            'id': {
                'read_only': True,
            },
            # 'password': {
            #     'write_only': True,
            # },
        }