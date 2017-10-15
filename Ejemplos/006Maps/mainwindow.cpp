#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QJsonDocument>
#include <QJsonArray>
#include <QJsonObject>
#include <QFile>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_button_clicked()
{
    QFile defaultTextFile("/home/esvux/QtProjects/EDD_Demo/mapa.html");
    defaultTextFile.open(QIODevice::ReadOnly);
    QString html = defaultTextFile.readAll();
    QString markers = "";
    QString json = ui->textEdit->toPlainText();
    QJsonDocument doc = QJsonDocument::fromJson(json.toUtf8());
    if(doc.isArray()){
        QJsonArray array = doc.array();
        for(int i = 0; i < array.size(); i++){
            QJsonObject elem = array[i].toObject();
            /*
                var marker = new google.maps.Marker({
                    map: map,
                    position: {14.0, -90.0},
                    title: 'Hello World!'
                });
            */
            markers.append(QString("var marker%1 = new google.maps.Marker({map: map,position: {lat:%2, lng:%3},title: '%4',icon:image});\n")
                    .arg(
                        QString::number(i),
                        QString::number(elem["lat"].toDouble()),
                        QString::number(elem["lng"].toDouble()),
                        elem["codigo"].toString()
                    ));
        }
    }

    ui->webView->setContent(html.replace("###",markers).toUtf8());
}
