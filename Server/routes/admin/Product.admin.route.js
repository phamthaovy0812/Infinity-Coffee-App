import ProductAdminController from '../../controllers/admin/Product.admin.controller.js';
import express from 'express';
import uploadCloud from '../../middlewares/uploader.js';

const router = express.Router();

router.get('/count', ProductAdminController.countProduct);
router.post(
  '/create',
  uploadCloud.single('image'),
  ProductAdminController.create
);
router.put(
  '/update/:id',
  uploadCloud.single('image'),
  ProductAdminController.update
);
router.put(
  '/updateWithoutImage/:id',
  ProductAdminController.updateWithoutImage
);
router.delete('/delete/:id', ProductAdminController.delete);
router.get('/:id', ProductAdminController.findOne);
router.get('/', ProductAdminController.findAll);
router.put('/disable/:id', ProductAdminController.disable);
router.put('/enable/:id', ProductAdminController.enable);
router.put('/available/:id', ProductAdminController.available);
router.put('/unavailable/:id', ProductAdminController.unavailable);

export default router;
