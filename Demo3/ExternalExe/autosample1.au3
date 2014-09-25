
WinWait("[CLASS:#32770]","",10)
; set input focus to the edit control of upload window using the handle Return by WinWait
ControlFocus ( "File Upload", "", "Edit1" )
Sleep(2000)

; set the file name text on the edit field

ControlSetText("File Upload","","Edit1","TxnsZipped")

;Click on the open button

ControlClick("File Upload", "","Button1")
