import OrderServices from '../../services/Order.service.js';

const OrderAdminController = {
  totalOrder: async (req, res) => {
    const total = await OrderServices.totalOrder();
    if (total) {
      res.status(200).send({ total });
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  findAllByDate: async (req, res) => {
    console.log("dwgsdaf")
    const orders = await OrderServices.findAllByDate();
    if (orders) {
      res.status(200).send(orders);
    } else {
      res.status(404).send({ status: 0, message: "Failed" });
    }
  },
  findAllByMonthAndYear: async (req, res) => {
    console.log("dwgsdaf")
    const value = req.params
    const orders = await OrderServices.findAllByMonthAndYear(value.month, value.year);
    if (orders) {
      res.status(200).send(orders);
    } else {
      res.status(404).send({ status: 0, message: "Failed" });
    }
  },
  findAllByWeek: async (req, res) => {
    console.log("dwgsdaf")
    const orders = await OrderServices.findAllByWeek();
    if (orders) {
      res.status(200).send(orders);
    } else {
      res.status(404).send({ status: 0, message: "Failed" });
    }
  },
  findAllByMonth: async (req, res) => {
    console.log("dwgsdafmonth")
    const orders = await OrderServices.findAllByMonth();
    if (orders) {
      res.status(200).send(orders);
    } else {
      res.status(404).send({ status: 0, message: "Failed" });
    }
  },
  countOrder: async (req, res) => {
    const count = await OrderServices.countOrder();
    if (count) {
      res.status(200).send({ count });
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  changeDenyStatus: async (req, res) => {
    const id = req.params.id;
    const status = await OrderServices.changeStatus(id, -1);
    if (status) {
      res.status(200).send({ status: 1, message: 'Success' });
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  changeDeliveredStatus: async (req, res) => {
    const id = req.params.id;
    const status = await OrderServices.changeStatus(id, 2);
    if (status) {
      res.status(200).send({ status: 1, message: 'Success' });
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  changeAcceptStatus: async (req, res) => {
    const id = req.params.id;
    const status = await OrderServices.changeStatus(id, 1);
    if (status) {
      res.status(200).send({ status: 1, message: 'Success' });
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  create: async (req, res) => {
    const {
      user_id,
      order_date,
      shipping_address,
      total,
      status,
      promotion_id,
      payment_method_id,
    } = req.body;
    const newOrder = await OrderServices.create(
      user_id,
      order_date,
      shipping_address,
      total,
      status,
      promotion_id,
      payment_method_id
    );
    if (newOrder) {
      res.status(200).send(newOrder);
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  update: async (req, res) => {
    const id = req.params.id;
    const {
      user_id,
      order_date,
      shipping_address,
      total,
      status,
      promotion_id,
      payment_method_id,
    } = req.body;
    const updateOrder = await OrderServices.update(
      id,
      user_id,
      order_date,
      shipping_address,
      total,
      status,
      promotion_id,
      payment_method_id
    );
    if (updateOrder) {
      res.status(200).send(updateOrder);
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  delete: async (req, res) => {
    const id = req.params.id;
    const status = await OrderServices.delete(id);
    if (status) {
      res.status(200).send({ status: 1, message: 'Success' });
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  findOne: async (req, res) => {
    const id = req.params.id;
    const order = await OrderServices.findOne(id);
    if (order) {
      res.status(200).send(order);
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
  findAll: async (req, res) => {
    const orders = await OrderServices.findAll();
    if (orders) {
      res.status(200).send(orders);
    } else {
      res.status(404).send({ status: 0, message: 'Failed' });
    }
  },
};

export default OrderAdminController;
