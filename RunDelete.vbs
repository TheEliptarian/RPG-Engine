Set WshShell = CreateObject("WScript.Shell" ) 
WshShell.Run chr(34) & "Scripts\delete.bat" & Chr(34), 0 
Set WshShell = Nothing 