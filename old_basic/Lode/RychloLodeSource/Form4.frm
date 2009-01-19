VERSION 5.00
Begin VB.Form Form4 
   BackColor       =   &H00000000&
   BorderStyle     =   1  'Fixed Single
   Caption         =   " Tvùj stav"
   ClientHeight    =   5265
   ClientLeft      =   12150
   ClientTop       =   3285
   ClientWidth     =   4635
   Icon            =   "Form4.frx":0000
   LinkTopic       =   "Form4"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   351
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   309
   ShowInTaskbar   =   0   'False
   Begin VB.Frame Frame1 
      Appearance      =   0  'Flat
      BackColor       =   &H00000000&
      BorderStyle     =   0  'None
      ForeColor       =   &H00FFFFFF&
      Height          =   4635
      Left            =   -30
      TabIndex        =   0
      Top             =   600
      Width           =   4665
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   0
         X1              =   810
         X2              =   810
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   1
         X1              =   1410
         X2              =   1410
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   2
         X1              =   2010
         X2              =   2010
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   3
         X1              =   2610
         X2              =   2610
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   4
         X1              =   3210
         X2              =   3210
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   5
         X1              =   3810
         X2              =   3810
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   6
         X1              =   270
         X2              =   4350
         Y1              =   780
         Y2              =   780
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   1
         X1              =   270
         X2              =   4350
         Y1              =   1380
         Y2              =   1380
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   2
         X1              =   270
         X2              =   4350
         Y1              =   1980
         Y2              =   1980
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   3
         X1              =   270
         X2              =   4350
         Y1              =   2580
         Y2              =   2580
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   4
         X1              =   270
         X2              =   4350
         Y1              =   3180
         Y2              =   3180
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   5
         X1              =   270
         X2              =   4350
         Y1              =   3780
         Y2              =   3780
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   48
         Left            =   3870
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   47
         Left            =   3270
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   46
         Left            =   2670
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   45
         Left            =   2070
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   44
         Left            =   1470
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   43
         Left            =   870
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   42
         Left            =   270
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   41
         Left            =   3870
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   40
         Left            =   3270
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   39
         Left            =   2670
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   38
         Left            =   2070
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   37
         Left            =   1470
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   36
         Left            =   870
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   35
         Left            =   270
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   34
         Left            =   3870
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   33
         Left            =   3270
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   32
         Left            =   2670
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   31
         Left            =   2070
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   30
         Left            =   1470
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   29
         Left            =   870
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   28
         Left            =   270
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   27
         Left            =   3870
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   26
         Left            =   3270
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   25
         Left            =   2670
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   24
         Left            =   2070
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   23
         Left            =   1470
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   22
         Left            =   870
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   21
         Left            =   270
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   20
         Left            =   3870
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   19
         Left            =   3270
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   18
         Left            =   2670
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   17
         Left            =   2070
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   16
         Left            =   1470
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   15
         Left            =   870
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   14
         Left            =   270
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   13
         Left            =   3870
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   12
         Left            =   3270
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   11
         Left            =   2670
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   10
         Left            =   2070
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   9
         Left            =   1470
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   8
         Left            =   870
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   7
         Left            =   270
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   6
         Left            =   3870
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   5
         Left            =   3270
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   4
         Left            =   2670
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   3
         Left            =   2070
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   2
         Left            =   1470
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   1
         Left            =   870
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   0
         Left            =   270
         Top             =   240
         Width           =   480
      End
      Begin VB.Image imgPozadi1 
         Enabled         =   0   'False
         Height          =   4500
         Left            =   90
         Picture         =   "Form4.frx":058A
         Top             =   60
         Width           =   4500
      End
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      BackColor       =   &H00000000&
      Caption         =   "Tvùj stav"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   20.25
         Charset         =   238
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   495
      Left            =   0
      TabIndex        =   1
      Top             =   60
      Width           =   4605
   End
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Activate()
Me.Left = Form1.Left + Form1.Width + 100
Me.Top = Form1.Top
End Sub

Private Sub Form_Initialize()
Me.Left = Form1.Left + Form1.Width + 100
Me.Top = Form1.Top
End Sub

Private Sub Form_Load()
Me.Left = Form1.Left + Form1.Width + 100
Me.Top = Form1.Top
End Sub

Private Sub Form_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
Me.Left = Form1.Left + Form1.Width + 100
Me.Top = Form1.Top
End Sub
