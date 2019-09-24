let express = require('express');
let router = express.Router();
let userAuth = require('../../middleware/userAuth');
let User = require('../../schema/user');
let Item = require('../../schema/item');

router.post('/api/users/:userId/items',userAuth.verifyToken, async (req, res) => {
  try {
    const { userId } = req.params;
    const { name, description, amount } = req.body;
    const newItem = new Item({
      name,
      description,
      amount,
      user_id: userId
    });
    const item = await newItem.save();
    res.json({ item: item });
  } catch (error) {
    console.log(error.message);
  }
});
router.get('/api/users/:userId/items',userAuth.verifyToken ,async (req, res) => {
  try {
    const { userId } = req.params;

    const items = await Item.find({ user_id: userId });
    res.json({ items: items });
  } catch (error) {
    console.log(error.message);
  }
});

router.get('/api/items', userAuth.verifyToken, async (req, res) =>{
  try{
    const items = await Item.find({});
    res.json({ items: items });
  }catch(error){
    confirm.log(error.message);
  }
});

module.exports = router;
