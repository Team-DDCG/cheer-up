# Generated by Django 4.2.1 on 2023-05-16 16:17

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Resume',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=128, verbose_name='상품명')),
                ('price', models.IntegerField(verbose_name='가격')),
                ('resume_type', models.CharField(choices=[('단품', '단품'), ('세트', '세트')], max_length=8, verbose_name='상품유형')),
                ('tstamp', models.DateTimeField(auto_now_add=True, verbose_name='등록일시')),
            ],
            options={
                'verbose_name': '자기소개서',
                'verbose_name_plural': '자기소개서',
                'db_table': 'resume',
            },
        ),
    ]