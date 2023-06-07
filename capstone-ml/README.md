# Diagnese Modelling

## Summary
**Diagnese model** is used to classify disease types based on 131 types of symptoms and then the user inputs what symptoms the user feels. Using this model, this model can predict about 41 types of diseases in the dataset.

In this repository consist of 2 folders:
1. **"Dataset\"** folder that contains 3 csv files:

- **`Training.csv`** is a raw data dataset we downloaded at **Kaggle** with the title [**DISEASE PREDICTION USING MACHINE LEARNING WITH GUI**](https://www.kaggle.com/datasets/neelima98/disease-prediction-using-machine-learning?select=Training.csv) which we have translated into **Bahasa Indonesia** where this dataset contains **131 Feature Columns** in the form of symptoms and **1 Label Column** as a prognosis with **41 types of Disease**. This dataset will be used in model training which will be split into **Training set** and **Validation set**.
- **`Testing.csv`** is a raw data dataset we downloaded at **Kaggle** with the title [**DISEASE PREDICTION USING MACHINE LEARNING WITH GUI**](https://www.kaggle.com/datasets/neelima98/disease-prediction-using-machine-learning?select=Testing.csv) which we have translated into **Bahasa Indonesia** where this dataset contains **131 Feature Columns** in the form of symptoms and **1 Label Column** as a prognosis with **41 types of Disease**. This dataset will be used to **Testing** how well the model predicted.
- **`Deskripsi_dan_Dokter.csv`** contains list of **Deskripsi** and also **Dokter Spesialis** which will be used using conditioning based on the output of the model prediction result. 

2. **"Model h5\"** folder that contain 1 file :

- `model.h5` that saving the best model into `.hdf5` for re-training or just load to make some prediction with the model.

In this repository consist of 3 files:
1. `diagnese_model.ipynb` that process to building model for our **Diagnes** app.
2. `diagnese_model_testing.ipynb` that process to testing our `hdf5` model to test how well the model predicts the data.
3. `requirements.txt` that consist library version required for this modelling.

## 1. `diagnese_model.ipynb`

## A. How to Make the Model?
1. Load datasets from **"Training.csv"** and **"Testing.csv"** using Pandas from **Dataset** folder.
2. Checking structur of data to gain an initial understanding of our **"Training.csv"** and **"Testing.csv"** dataset.
3. Examine the DataFrame for the data shape dimensions of the datasets **"Training.csv"** and **"Testing.csv"** using Pandas.
4. Checks empty cell of our **"Training.csv"** and **"Testing.csv"** datasets for make sure our dataset columns that do not have values using Pandas.
5. Check the prognosis column which will be the label/target y to find out how many types of data each disease has.

## B. Data Preparation for Modelling
1. Separate the **feature** column (x) and the **target/label** column (y). Feature column is the **symptoms** starting from column 1-131, while Label is in the 132 column named **prognosis** on **"Training.csv"** and **"Testing.csv"** dataset.
2. Split dataset **"Training.csv"** for 2 usage, there is **80%** proportion of data used for **training** and **20%** proportion of data for **validation**.
3. **Label** y has a string data type, it needs to be converted to numeric with `LabelEncoder` using **Scikit-Learn**.

## C. Modelling Process
1. Define the model, in this scope the model uses:
- 1 layer of keras Dense layer
- 1 layer of keras Dropout layer
- 1 layer of keras Dense layer

>The activation function in first Dense layer is `ReLu` because `ReLu` is one of the best activation function. No activation function for Dropout layer. For the last Dense Layer we have `softmax` activation function for multiclass clasification.

2. Compile the model. To fit this model the"Stochastic Gradient Descent" `SGD` better for optimizer. The loss function is `"sparse_categorical_crossentropy"` which is better for multi-class classification with `LabelEncoder` and `accuracy` as metric.
3. Fit the model with 20 `epoch`, 13 `batch_size` and `X_val` and `y_val` as validation data. For more detail can be seen in the following picture:

>><img src="https://github.com/jumli-gazali/diagnese/raw/jumli/Gambar/Model%20summary.png" width="400">


## D. Evaluate Model
1. Evaluate the model to see performance model with `evaluate` method. For more detail can be seen in the following picture:

>><img src="https://github.com/jumli-gazali/diagnese/raw/jumli/Gambar/Model%20evaluate.png" width="400">

2. Plot the accuracy of the model in the epoch. The plot is the accuracy of both the train set and validation set data. After that, look at the graph. If the graph shows continue increase at each epoch, then the model is well-fit. For more detail can be seen in the following picture:

>><img src="https://github.com/jumli-gazali/diagnese/raw/jumli/Gambar/Plot%20Acc.png" width="400">

3. Plot the loss of the model in the epoch. The plot is the loss of both the train set and validation set data. After that, look at the graph. The graph should continue decrease at each epoch, then the model is well-fit. For more detail can be seen in the following picture:

>><img src="https://github.com/jumli-gazali/diagnese/raw/jumli/Gambar/Plot%20Loss.png" width="400">

4. Evaluate the model with classification report for get information. For more detail can be seen in the following picture:

>><img src="https://github.com/jumli-gazali/diagnese/raw/jumli/Gambar/CL%20Report.png" width="400">

## E. Save Model
Save the best model into `.hdf5` for re-training or just load to make some prediction with the model.


## 2. `diagnese_model_testing.ipynb`

## A. How to use `H5` model?

### i. Data Processing
1. Load **"Testing.csv"** dataset using 'pandas'.
2. Separate the **feature** column (x) and the **target/label** column (y). Feature column is the **symptoms** starting from column 1-131, while Label is in the 132 column named **prognosis** on **Testing.csv**
3. Convert label into numeric using `LabelEncoder` from **Scikit-Learn**
4. Load **"Deskripsi_dan_Dokter.csv"** using `csv`.

### ii. Load `hdf5` Model
From `keras`, import `load_model` using code below:

```
from keras.models import load_model
```

Load `h5` model from **Model h5** folder using code below:

```
model = load_model('Model h5/model.h5')
```

### iii. Predict Model
Define loop get 41 row of dataset as input, then predict into the model `h5` loaded. 

## 3. `requirements.txt`
Contains the required library version, along with the library and version:
1. tensorflow==2.12.0
2. pandas==1.5.3
3. numpy==1.23.5
4. matplotlib==3.7.0

## Library used for building `Diagnese Model`
1. [TensorFlow](https://www.tensorflow.org/)
2. [Pandas](https://pandas.pydata.org/)
3. [Numpy](https://numpy.org/doc/)
4. [Matplotlib](https://matplotlib.org/stable/index.html)
5. [Csv](https://docs.python.org/3/library/csv.html)
6. [Sckit-Learn](https://scikit-learn.org/0.21/documentation.html#)

## Tool used for building `Diagnese Model`
1. [Google Colab](https://colab.research.google.com/notebooks/intro.ipynb#recent=true)
2. [Jupyter Notebook]()
3. [Google Spreadsheet](https://docs.google.com/spreadsheets/d/1b2fc-CGsCwpvIpAYlB_7KxWd4xDG-bJA9jMCkKLZ2cM/edit?hl=id#gid=0)

## Source of Dataset
1. [Kaggle](https://www.kaggle.com/datasets/neelima98/disease-prediction-using-machine-learning?select=Training.csv)


## Contribution
All `Diagnese` app team

 
