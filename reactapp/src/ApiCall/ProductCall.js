export class ProductCall {

    static async get(url) {
        try {
            const data = await fetch(url);
            console.log(data);
            return await data.json();
            
        } catch (error) {
            console.log(error);
        }
    }

    static async addCart(url) {
        try {
            const data = await fetch(url, {
                method:'POST'
            });
            console.log(data);
            return await data.json();
            
        } catch (error) {
            console.log(error);
        }
    }
}
