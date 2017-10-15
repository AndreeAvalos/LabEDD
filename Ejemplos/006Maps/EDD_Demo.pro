#-------------------------------------------------
#
# Project created by QtCreator 2017-10-11T04:40:49
#
#-------------------------------------------------

QT       += core gui
#Paso 1: Agregar los componentes web
QT       += webkitwidgets
QT       += network


greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = EDD_Demo
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp

HEADERS  += mainwindow.h

FORMS    += mainwindow.ui

DISTFILES += \
    mapa.html
