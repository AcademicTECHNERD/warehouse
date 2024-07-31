const http = require('http')
const fs = require('fs')
const path = require('path') 

const server = http.createServer();
server.on('request',(req,res) => {
        console.log("someone visit")
        const url = req.url 
        console.log('url==' + url)
        console.log('__dirname是' + __dirname)
        let fpath = ''
        fpath = path.join(__dirname,'./introduce.html')

        fs.readFile(fpath ,'utf8' , (err,dataStr) => {
            console.log('fpath是' + fpath)
        if(err){
            return res.end('404 not found')
        }
        return res.end(dataStr)
})
 })
server.listen(8080,() => {
        console.log('server running at http://127.0.0.1:8080')
})