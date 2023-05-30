import { DataTypes } from 'sequelize';
import db from '../configs/db.config.js';

// Galleries attribute database schema
export const Galleries = db.define('galleries', {
  id: {
    type: DataTypes.STRING,
    primaryKey: true,
    allowNull: false,
  },
  title: {
    type: DataTypes.STRING,
  },
  imageUrl: {
    type: DataTypes.STRING,
  },
  filename: {
    type: DataTypes.STRING,
  },
  description: {
    type: DataTypes.STRING,
  },
  createdAt: {
    type: DataTypes.DATE,
    allowNull: false,
    defaultValue: DataTypes.NOW
  },
  updatedAt: {
    type: DataTypes.DATE,
    allowNull: false,
    defaultValue: DataTypes.NOW
  },
}, {
  freezeTableName: true
});
