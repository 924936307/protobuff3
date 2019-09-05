@echo off

for /f "delims=\" %%a in ('dir /b /a-d /o-d ".\*.proto"') do (
	cd /d %cd%
	protoc.exe -I=.\ --java_out=..\src\main\java\  .\%%a
)

pause

