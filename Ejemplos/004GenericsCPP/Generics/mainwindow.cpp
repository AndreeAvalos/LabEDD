#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "mylist.h"
#include "person.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    list = new MyList<Person>();
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_btnAddRegister_clicked()
{
    QString firstName = ui->txtFirstName->text();
    QString lastName = ui->txtLastName->text();
    QString career = ui->txtCareer->text();
    Person p(firstName, lastName, career);
    list->add(p);
}

void MainWindow::on_btnShowList_clicked()
{
    list->print();
}
