import DB from '../configs/db.js';
const PromotionRepository = {
  async countPromotion() {
    const query = `SELECT COUNT(*) AS count FROM promotion`;
    try {
      const [result] = await DB.pool().query(query);
      return result[0].count;
    } catch (error) {
      console.error(error);
      return false;
    }
  },
  async changeIsDisable(id, isDisable) {
    const query = `UPDATE promotion SET is_disable=? WHERE id=?`;
    const values = [isDisable, id];
    try {
      const [result] = await DB.pool().query(query, values);
      return result;
    } catch (error) {
      console.error(error);
      return false;
    }
  },
  async create(
    name,
    description,
    discount,
    start_date,
    end_date,
    image,
    quantity,
    code
  ) {
    const query = `INSERT INTO promotion (name, description, discount, start_date, end_date, image, quantity, code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)`;
    const values = [
      name,
      description,
      discount,
      start_date,
      end_date,
      image,
      quantity,
      code,
    ];
    try {
      DB.pool().query(query, values);
      return true;
    } catch (error) {
      console.error(error);
      return false;
    }
  },
  async updateWithoutImage(
    id,
    name,
    description,
    discount,
    start_date,
    end_date,
    quantity,
    code
  ) {
    const query = `UPDATE promotion SET name=?, description=?, discount=?, start_date=?, end_date=?, quantity=?, code=? WHERE id=?`;
    const values = [
      name,
      description,
      discount,
      start_date,
      end_date,
      quantity,
      code,
      id,
    ];

    try {
      const [result] = await DB.pool().query(query, values);
      return result.affectedRows > 0;
    } catch (error) {
      console.error(error);
      return false;
    }
  },
  async update(
    id,
    name,
    description,
    discount,
    start_date,
    end_date,
    image,
    quantity,
    code
  ) {
    const query = `UPDATE promotion SET name=?, description=?, discount=?, start_date=?, end_date=?, image=?, quantity=?, code=? WHERE id=?`;
    const values = [
      name,
      description,
      discount,
      start_date,
      end_date,
      image,
      quantity,
      code,
      id,
    ];

    try {
      const [result] = await DB.pool().query(query, values);
      return result.affectedRows > 0;
    } catch (error) {
      console.error(error);
      return false;
    }
  },
  async delete(id) {
    const query = `DELETE FROM promotion WHERE id=?`;

    try {
      await DB.pool().query(query, [id]);
      return true;
    } catch (error) {
      console.error(error);
      return false;
    }
  },

  async findAll() {
    const query = `SELECT * FROM promotion ORDER BY id DESC`;

    try {
      const [rows] = await DB.pool().query(query);
      return rows;
    } catch (error) {
      console.error(error);
      return false;
    }
  },

  async findOneByID(id) {
    const query = `SELECT * FROM promotion WHERE id = ?`;
    const value = [id];

    try {
      const [rows] = await DB.pool().query(query, value);
      return rows[0];
    } catch (error) {
      console.error(error);
      return false;
    }
  },
};

export default PromotionRepository;
