#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include "mylist.h"
#include "person.h"
#include <QMainWindow>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void on_btnAddRegister_clicked();
    void on_btnShowList_clicked();

private:
    Ui::MainWindow *ui;
    MyList<Person> *list;
};

#endif // MAINWINDOW_H
