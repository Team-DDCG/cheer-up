from django.db import models

# Create your models here.

class UserInfo(models.Model):
    user_id = models.CharField(max_length=32, null=True, blank=True, verbose_name="id")
    name = models.CharField(max_length=32, null=True, blank=True, verbose_name="name")
    tel = models.CharField(max_length=32, null=True, blank=True, verbose_name="연락처")
    # status = models.CharField(max_length=16, default="일반",
    #     choices=(
    #         ('일반','일반'),
    #         ('탈퇴','탈퇴'),
    #         ('휴면','휴면'),
    #     )
    # )
    # REQUIRED_FIELDS = ["tel"]

    class Meta:
        db_table = 'user_info'
        verbose_name = '회원'
        verbose_name_plural = '회원'