# Diagnese Modelling

## Summary
**Diagnese model** is used to classify disease types based on 131 types of symptoms and then the user inputs what symptoms the user feels. Using this model, this model can predict about 41 types of diseases in the dataset.

In this folders consist 1 file:

`model.h5` that best model from `diagnes_model.ipynb` converted into `hdf5` / `h5` format for re-training or just load to make some prediction with the model.


## A. How to use `H5` model?

### 1. Import `load_mode`

From `keras`, import `load_model` using code below:

```
from keras.models import load_model
```

### 2. Load `hdf5` Model

Load `h5` model from **Model h5** folder using code below:

```
model = load_model('Model h5/model.h5')
```
 
