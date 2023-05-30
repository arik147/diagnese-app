import { Sequelize } from "sequelize";

const db = new Sequelize('diagnese_db', 'postgres', 'ciwaregu123', {
  host: '34.101.200.216',
  dialect: 'postgres'
});

// Sinkron table pada db dari model
/* db.sync({alter: true})
  .then(() => {
    console.log('Tabel berhasil di sinkronisasi');
  })
  .catch((error) => {
    console.error('Terjadi kesalahan:', error);
  }); */

export default db;
