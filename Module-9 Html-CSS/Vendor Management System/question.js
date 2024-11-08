const vendorDatabase = {};

function registerVendor(vendorId, restaurantName, address, menuItems, currency, locale, lastOrderDate) {
    vendorDatabase[vendorId] = {
        restaurantName,
        address,
        menuItems,   
        currency,   
        locale,      
        lastOrderDate 
    };
    console.log(`Vendor ${restaurantName} registered successfully.`);
}

function fetchVendorDetails(vendorId) {
    return new Promise((resolve, reject) => {
        const vendor = vendorDatabase[vendorId];
        if (vendor) {
            resolve(vendor);
        } else {
            reject(`Vendor with ID ${vendorId} not found.`);
        }
    });
}

function formatMenuPrices(menuItems, currency, locale) {
    return menuItems.map(item => ({
        itemName: item.itemName,
        price: new Intl.NumberFormat(locale, {
            style: 'currency',
            currency: currency
        }).format(item.price)
    }));
}

function formatOrderDate(lastOrderDate, locale) {
    return new Intl.DateTimeFormat(locale).format(lastOrderDate);
}


registerVendor(
    'v1',
    'Tasty Bites',
    'New York, USA',
    [{ itemName: 'Burger', price: 10 }, { itemName: 'Pizza', price: 15 }],
    'USD',
    'en-US',
    new Date('2024-11-01')
);

registerVendor(
    'v2',
    'Spice Corner',
    'Kollam Kerala',
    [{ itemName: 'Chicken Curry', price: 200 }, { itemName: 'Biryani', price: 200 }],
    'INR',
    'en-IN',
    new Date('2024-11-02')
);

fetchVendorDetails('v1')
    .then(vendor => {
        console.log(`Vendor Details for ${vendor.restaurantName}:`);
        const formattedMenu = formatMenuPrices(vendor.menuItems, vendor.currency, vendor.locale);
        console.log("Menu Items with Localized Prices:", formattedMenu);
        console.log("Last Order Date:", formatOrderDate(vendor.lastOrderDate, vendor.locale));
    })
    .catch(error => {
        console.error(error);
    });

fetchVendorDetails('v2')
    .then(vendor => {
        console.log(`Vendor Details for ${vendor.restaurantName}:`);
        const formattedMenu = formatMenuPrices(vendor.menuItems, vendor.currency, vendor.locale);
        console.log("Menu Items with Localized Prices:", formattedMenu);
        console.log("Last Order Date:", formatOrderDate(vendor.lastOrderDate, vendor.locale));
    })
    .catch(error => {
        console.error(error);
    });
