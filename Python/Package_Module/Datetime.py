import datetime

TimeNow = datetime.datetime.now()
BirthDay = datetime.datetime(1997, 1, 24,0,0,0)

time1 = datetime.timedelta(hours=2,minutes = -30)
print(TimeNow - BirthDay)

print(TimeNow)
print(TimeNow - time1)

print(type(TimeNow - BirthDay))